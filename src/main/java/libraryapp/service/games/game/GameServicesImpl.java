package libraryapp.service.games.game;

import libraryapp.comparators.game.ComparatorSorting;
import libraryapp.dto.GameEntityV2Dto;
import libraryapp.entities.games.GameEntity;
import libraryapp.entities.games.PublisherEntity;
import libraryapp.models.response.GameResponse;
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
public class GameServicesImpl implements GameServices<GameResponse> {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;
    private final ComparatorSorting comparatorSorting;
    private final GameTransformerImpl gameTransformer;


    public GameServicesImpl(GameRepository gameRepository,
                            ComparatorSorting comparatorSorting,
                            UserRepository userRepository,
                            DeveloperRepository developerRepository,
                            PublisherRepository publisherRepository) {
        this.gameRepository = gameRepository;
        this.comparatorSorting = comparatorSorting;
        this.userRepository = userRepository;
        this.developerRepository = developerRepository;
        this.gameTransformer = new GameTransformerImpl();
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<GameEntityV2Dto> getCollection(SortBy sortBy, Order order, int userId) {

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

        List<GameResponse> listOfGames = comparatorSorting.getListOfGames();
        return null;
    }

    @Override
    public GameResponse getItem(int id) {
        return gameTransformer.getGameFromEntity(gameRepository.findById(id).orElseThrow());
    }

    @Override
    public List<GameResponse> findGamesByDev_Name(String developerName) {
        Optional<List<GameEntity>> byDeveloper = gameRepository.findByDeveloper_Name(developerName);

        return byDeveloper
                .orElseThrow()
                .stream()
                .map(comparatorSorting::mapToGame)
                .collect(Collectors.toList());
    }

    @Override
    public List<GameResponse> findGamesByPub_Name(String publisherName) {
        Optional<List<GameEntity>> byPublisher_name = gameRepository.findByPublisher_Name(publisherName);

        return byPublisher_name
                .orElseThrow()
                .stream()
                .map(comparatorSorting::mapToGame)
                .collect(Collectors.toList());
    }

    @Override
    public void addGame(GameResponse gameModel) {

    }

    @Override
    public void addGame(GameEntityV2Dto gameModel) {
//        GameEntity gameEntity = gameTransformer.getEntityFromGame(gameModel);
//
//        gameEntity.setUser(userRepository.findById(gameModel.getUserId()).get());
//        gameEntity.setDeveloper(developerRepository.findById(gameModel.getDevId()).get());
//
//        List<PublisherEntity> all = publisherRepository.findAll();
//
//        Optional<PublisherEntity> byId = publisherRepository.findById(gameModel.getPubId());
//        PublisherEntity publisherEntity = byId.get();
//
//        PublisherEntity publisher = publisherEntity;
//
//        gameEntity.setPublisher(publisher);
//
//        gameRepository.save(gameEntity);
    }

}
