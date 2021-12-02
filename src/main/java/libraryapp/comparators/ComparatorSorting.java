package libraryapp.comparators;

import libraryapp.entities.games.GameEntity;
import libraryapp.models.GameModel;
import libraryapp.models.PublisherModel;
import libraryapp.repository.GameRepository;
import libraryapp.transformer.DeveloperTransformerImpl;
import libraryapp.transformer.GameTransformerImpl;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComparatorSorting {

    private final GameRepository gameRepository;
    private final GameTransformerImpl gameTransformer;
    private final DeveloperTransformerImpl developerTransformer;

    private List<GameModel> listOfGames;

    public ComparatorSorting(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.gameTransformer = new GameTransformerImpl();
        this.developerTransformer = new DeveloperTransformerImpl();
    }

    public List<GameModel> getListOfGames() {
        return listOfGames;
    }

    public GameModel toGame(GameEntity gameEntity) {
        return gameTransformer.getGameFromEntity(gameEntity);
    }

    public GameModel mapToGame(GameEntity gameEntity) {
        GameModel gameModel = gameTransformer.getGameFromEntity(gameEntity);

        gameModel.setDeveloper(developerTransformer.toDeveloperModel(gameEntity.getDeveloper()));
        gameModel.setPublisher(new PublisherModel(gameEntity.getPublisher().getName()));

        return gameModel;
    }

    public void orderByDesc() {
        Collections.reverse(listOfGames);
    }

    public void sortByRating() {
        listOfGames = gameRepository
                .findAll()
                .stream()
                .sorted(new GameRatingComparator())
                .map(this::mapToGame)
                .collect(Collectors.toList());
    }

    public void sortByName() {
        listOfGames = gameRepository
                .findAll()
                .stream()
                .sorted(new GameNameComparator())
                .map(this::toGame)
                .collect(Collectors.toList());
    }

    public void sortByReleaseDate() {
        listOfGames = gameRepository
                .findAll()
                .stream()
                .sorted(new GameReleaseDateComparator())
                .map(this::toGame)
                .collect(Collectors.toList());
    }
}
