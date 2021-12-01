package libraryapp.comparators;

import libraryapp.entities.games.GameEntity;

import java.util.Comparator;

public class GameReleaseDateComparator implements Comparator<GameEntity> {
    @Override
    public int compare(GameEntity o1, GameEntity o2) {
        if (o1.getReleaseDate().isBefore(o1.getReleaseDate())) {
            return 1;
        } else {
            return 0;
        }
    }
}
