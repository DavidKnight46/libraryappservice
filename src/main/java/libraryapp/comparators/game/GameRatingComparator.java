package libraryapp.comparators.game;

import libraryapp.entities.games.GameEntityV2;

import java.util.Comparator;

public class GameRatingComparator implements Comparator<GameEntityV2> {

    @Override
    public int compare(GameEntityV2 o1, GameEntityV2 o2) {
        if (o1.getGameRating() > o2.getGameRating()) {
            return Math.round(o1.getGameRating());
        } else {
            return Math.round(o2.getGameRating());
        }
    }
}
