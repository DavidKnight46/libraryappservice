package libraryapp.service.games.game.cloud;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.AWSDynamoDBModel;

public class AWSDynamoDBModelAdapter {

    public AWSDynamoDBModel convertTo(GameEntityV2Dto gameEntityV2Dto){
        return new AWSDynamoDBModel(gameEntityV2Dto.getGameName(),
                gameEntityV2Dto.getGameGenre(),
                gameEntityV2Dto.getPlatform(),
                gameEntityV2Dto.getUserName(),
                gameEntityV2Dto.getReleaseDate(),
                gameEntityV2Dto.getGameRating(),
                gameEntityV2Dto.getImageUrl(),
                gameEntityV2Dto.getPreOrdered());

    }

}
