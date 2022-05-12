package libraryapp.comparators.gameV2;

import libraryapp.entities.games.GameEntityV2;

import java.util.Comparator;

public class GameRatingComparator implements Comparator<GameEntityV2> {
    @Override
    public int compare(GameEntityV2 o1, GameEntityV2 o2) {
        if (o1.getGameRating() > o2.getGameRating()) {
            return Math.getExponent(o1.getGameRating());
        } else {
            return Math.getExponent(o2.getGameRating());
        }
    }

}
