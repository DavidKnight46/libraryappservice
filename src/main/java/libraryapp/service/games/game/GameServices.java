package libraryapp.service.games.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.response.GameResponse;
import libraryapp.service.CollectionService;

import java.util.List;

public interface GameServices extends CollectionService<GameEntityV2Dto> {
    void addGame(GameEntityV2Dto gameModel);

    List<GameEntityV2Dto> findGamesByDev_Name(String developerName);

    List<GameEntityV2Dto> findGamesByPub_Name(String developerName);
}
