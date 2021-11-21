package libraryapp.service.games.game;

import libraryapp.models.GameModel;
import libraryapp.service.CollectionService;

public interface GameServices<T> extends CollectionService<GameModel> {
    T findGameByDev();
}
