package libraryapp.comparators.game;

import libraryapp.entities.games.GameEntityV2;

import java.util.Comparator;

public class GameNameComparator implements Comparator<GameEntityV2> {

    @Override
    public int compare(GameEntityV2 o1, GameEntityV2 o2) {
        return o1.getGameName().compareTo(o2.getGameName());
    }
}
