package libraryapp.service.games.game;

import libraryapp.aws.dynamo.AWSDynamoDBModel;
import libraryapp.dto.GameEntityV2Dto;
import libraryapp.service.CollectionService;

import java.util.List;

public interface GameServices extends CollectionService<AWSDynamoDBModel> {
    void addGame(GameEntityV2Dto gameModel, int id);

    List<GameEntityV2Dto> findGamesByDev_Name(String developerName);

    List<GameEntityV2Dto> findGamesByPub_Name(String developerName);
}
