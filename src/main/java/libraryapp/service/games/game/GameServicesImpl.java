package libraryapp.service.games.game;

import libraryapp.comparators.ComparatorSorting;
import libraryapp.entities.games.GameEntity;
import libraryapp.models.GameModel;
import libraryapp.repository.GameRepository;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.transformer.DeveloperTransformerImpl;
import libraryapp.transformer.GameTransformerImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServicesImpl implements GameServices<GameModel> {

    private final GameRepository gameRepository;
    private final GameTransformerImpl gameTransformer;
    private final DeveloperTransformerImpl developerTransformer;
    private final ComparatorSorting comparatorSorting;

    public GameServicesImpl(GameRepository gameRepository, ComparatorSorting comparatorSorting) {
        this.gameRepository = gameRepository;
        this.gameTransformer = new GameTransformerImpl();
        this.developerTransformer = new DeveloperTransformerImpl();
        this.comparatorSorting = comparatorSorting;
    }

    @Override
    public List<GameModel> getCollection(SortBy sortBy, Order order) {

        switch (sortBy) {
            case NAME:
                comparatorSorting.sortByName();
                break;
            case RATING:
                comparatorSorting.sortByRating();
                break;
            case RELEASE_DATE:
                comparatorSorting.sortByReleaseDate();
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
                .map(comparatorSorting::toGame)
                .collect(Collectors.toList());
    }

    @Override
    public List<GameModel> findGamesByPub_Name(String publisherName) {
        Optional<List<GameEntity>> byPublisher_name = gameRepository.findByPublisher_Name(publisherName);

        return byPublisher_name
                .orElseThrow()
                .stream()
                .map(comparatorSorting::toGame)
                .collect(Collectors.toList());
    }

}
