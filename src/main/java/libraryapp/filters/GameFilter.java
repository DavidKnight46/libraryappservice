package libraryapp.filters;

import libraryapp.entities.games.GameEntityV2;

import java.util.List;

public class GameFilter implements Filter<GameEntityV2>{

    @Override
    public GameEntityV2 filterByGenre(List<GameEntityV2> items, String genreName) {
        return null;
    }
}
