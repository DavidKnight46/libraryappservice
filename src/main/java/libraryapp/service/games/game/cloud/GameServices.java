package libraryapp.service.games.game.cloud;

import libraryapp.models.AWSDynamoDBModel;
import libraryapp.service.CollectionService;

public interface GameServices extends CollectionService<AWSDynamoDBModel> {
    //void addGame(GameEntityV2Dto gameModel);

    void deleteGame(String userName, String gameName);
}
