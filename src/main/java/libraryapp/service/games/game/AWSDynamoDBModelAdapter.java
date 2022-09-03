package libraryapp.service.games.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.AWSDynamoDBModel;

import java.util.List;

public class AWSDynamoDBModelAdapter {

    public AWSDynamoDBModel convertTo(GameEntityV2Dto gameEntityV2Dto){
        return new AWSDynamoDBModel(gameEntityV2Dto.getGameName(),
                gameEntityV2Dto.getGameGenre(),
                gameEntityV2Dto.getPlatform(),
                "",
                gameEntityV2Dto.getReleaseDate(),
                gameEntityV2Dto.getGameRating(),
                gameEntityV2Dto.getImageUrl(),
                gameEntityV2Dto.getPreOrdered());

    }

}
