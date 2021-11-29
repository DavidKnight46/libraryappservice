package libraryapp.comparators;

import libraryapp.entities.games.GameEntity;

import java.util.Comparator;

public class GameRatingComparator implements Comparator<GameEntity> {

    @Override
    public int compare(GameEntity o1, GameEntity o2) {
        if(o1.getRating() > o2.getRating()) {
            return o1.getRating();
        } else {
            return o2.getRating();
        }
    }
}
