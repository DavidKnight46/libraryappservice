package libraryapp.service.games.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.request.GameModelRequest;
import libraryapp.models.response.GameResponse;
import libraryapp.service.CollectionService;

import java.util.List;

public interface GameServices<T> extends CollectionService<GameResponse> {
    List<T> findGamesByDev_Name(String developerName);

    List<T> findGamesByPub_Name(String developerName);

    void addGame(T gameModel);

    void addGame(GameEntityV2Dto gameModel);
}
