package libraryapp.comparators.gameV2;

import libraryapp.entities.games.GameEntityV2;

import java.util.Comparator;

public class GameReleaseDateComparator implements Comparator<GameEntityV2> {
    @Override
    public int compare(GameEntityV2 o1, GameEntityV2 o2) {
        if (o1.getReleaseDate().isBefore(o1.getReleaseDate())) {
            return 1;
        } else {
            return 0;
        }
    }
}
