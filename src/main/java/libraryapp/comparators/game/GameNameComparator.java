package libraryapp.comparators.game;

import libraryapp.entities.games.GameEntity;

import java.util.Comparator;

public class GameNameComparator implements Comparator<GameEntity> {

    @Override
    public int compare(GameEntity o1, GameEntity o2) {
        return o1.getGameName().compareTo(o2.getGameName());
    }
}
