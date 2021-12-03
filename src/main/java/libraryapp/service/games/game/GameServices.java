package libraryapp.service.games.game;

import libraryapp.models.GameModel;
import libraryapp.service.CollectionService;

import java.util.List;

public interface GameServices<T> extends CollectionService<GameModel> {
    List<T> findGamesByDev_Name(String developerName);

    List<T> findGamesByPub_Name(String developerName);

    void addGame(GameModel gameModel, int userId);

}
