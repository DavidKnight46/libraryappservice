package libraryapp.service.games.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.AWSDynamoDBModel;
import libraryapp.service.CollectionService;

import java.util.List;

public interface GameServices extends CollectionService<AWSDynamoDBModel> {
    void addGame(GameEntityV2Dto gameModel);

    boolean editGame(GameEntityV2Dto gameModel);

    boolean deleteGame();

}
