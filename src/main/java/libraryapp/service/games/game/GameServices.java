package libraryapp.service.games.game;

import libraryapp.models.request.GameModelRequest;
import libraryapp.models.response.GameResponse;
import libraryapp.service.CollectionService;

import java.util.List;

public interface GameServices<T> extends CollectionService<GameResponse> {
    List<T> findGamesByDev_Name(String developerName);

    List<T> findGamesByPub_Name(String developerName);

    void addGame(GameModelRequest gameModel);

}
