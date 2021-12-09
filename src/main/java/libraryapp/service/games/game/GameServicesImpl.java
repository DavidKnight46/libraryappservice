package libraryapp.service.games.game;

import libraryapp.comparators.ComparatorSorting;
import libraryapp.configuration.RawConfiguration;
import libraryapp.entities.games.DeveloperEntity;
import libraryapp.entities.games.GameEntity;
import libraryapp.entities.user.UserEntity;
import libraryapp.models.GameModel;
import libraryapp.repository.DeveloperRepository;
import libraryapp.repository.GameRepository;
import libraryapp.repository.PublisherRepository;
import libraryapp.repository.UserRepository;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.transformer.GameTransformerImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServicesImpl implements GameServices<GameModel> {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;
    private final ComparatorSorting comparatorSorting;
    private final GameTransformerImpl gameTransformer;
    private final RawConfiguration rawConfiguration;


    public GameServicesImpl(GameRepository gameRepository,
                            ComparatorSorting comparatorSorting,
                            UserRepository userRepository,
                            DeveloperRepository developerRepository,
                            PublisherRepository publisherRepository,
                            RawConfiguration rawConfiguration) {
        this.gameRepository = gameRepository;
        this.comparatorSorting = comparatorSorting;
        this.userRepository = userRepository;
        this.developerRepository = developerRepository;
        this.gameTransformer = new GameTransformerImpl();
        this.publisherRepository = publisherRepository;
        this.rawConfiguration = rawConfiguration;
    }

    @Override
    public List<GameModel> getCollection(SortBy sortBy, Order order, int userId) {

        switch (sortBy) {
            case NAME:
                comparatorSorting.sortByName(userId);
                break;
            case RATING:
                comparatorSorting.sortByRating(userId);
                break;
            case RELEASE_DATE:
                comparatorSorting.sortByReleaseDate(userId);
                break;
            default:
                break;
        }

        switch (order) {
            case DESC:
                comparatorSorting.orderByDesc();
                break;
            default:
                System.out.println("smurf");
                break;
        }

        return comparatorSorting.getListOfGames();
    }

    @Override
    public GameModel getItem(int id) {
        return gameTransformer.getGameFromEntity(gameRepository.findById(id).orElseThrow());
    }

    @Override
    public List<GameModel> findGamesByDev_Name(String developerName) {
        Optional<List<GameEntity>> byDeveloper = gameRepository.findByDeveloper_Name(developerName);

        return byDeveloper
                .orElseThrow()
                .stream()
                .map(comparatorSorting::mapToGame)
                .collect(Collectors.toList());
    }

    @Override
    public List<GameModel> findGamesByPub_Name(String publisherName) {
        Optional<List<GameEntity>> byPublisher_name = gameRepository.findByPublisher_Name(publisherName);

        return byPublisher_name
                .orElseThrow()
                .stream()
                .map(comparatorSorting::mapToGame)
                .collect(Collectors.toList());
    }

    @Override
    public void addGame(GameModel gameModel, int userId, int developerId, int publisherId) {
        GameEntity gameEntity = gameTransformer.getEntityFromGame(gameModel);

        gameEntity.setUser(userRepository.findById(userId).get());
        gameEntity.setDeveloper(developerRepository.findById(developerId).get());
        gameEntity.setPublisher(publisherRepository.findById(publisherId).get());

        gameRepository.save(gameEntity);
    }

}
