package libraryapp.comparators.game;

import libraryapp.entities.games.GameEntity;
import libraryapp.models.response.GameResponse;
import libraryapp.repository.GameRepository;
import libraryapp.transformer.DeveloperTransformerImpl;
import libraryapp.transformer.GameTransformerImpl;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComparatorSorting {

    private final GameRepository gameRepository;
    private final GameTransformerImpl gameTransformer;
    private final DeveloperTransformerImpl developerTransformer;

    private List<GameResponse> listOfGames;

    public ComparatorSorting(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.gameTransformer = new GameTransformerImpl();
        this.developerTransformer = new DeveloperTransformerImpl();
    }

    public List<GameResponse> getListOfGames() {
        return listOfGames;
    }

    public GameResponse mapToGame(GameEntity gameEntity) {
        GameResponse gameResponse = gameTransformer.getGameFromEntity(gameEntity);

        return gameResponse;
    }

    public void orderByDesc() {
        Collections.reverse(listOfGames);
    }

    public void sortByRating(int userId) {
        sortBy(new GameRatingComparator(), userId);
    }

    public void sortByName(int userId) {
        sortBy(new GameNameComparator(), userId);
    }

    public void sortByReleaseDate(int userId) {
        sortBy(new GameReleaseDateComparator(), userId);
    }

    private void sortBy(Comparator<GameEntity> comparator, int userId) {
        listOfGames = gameRepository
                .findByUserId(userId)
                .get()
                .stream()
                .sorted(comparator)
                .map(this::mapToGame)
                .collect(Collectors.toList());
    }
}
