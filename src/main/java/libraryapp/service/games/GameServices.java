package libraryapp.service.games;

import libraryapp.entities.games.GameEntity;
import libraryapp.models.GameModel;
import libraryapp.service.CollectionService;

public interface GameServices<T> extends CollectionService<GameModel> {
    T findGameByDev();
}
