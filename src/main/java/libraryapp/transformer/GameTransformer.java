package libraryapp.transformer;


import libraryapp.entities.games.GameEntity;
import libraryapp.models.response.GameResponse;
import libraryapp.models.request.GameModelRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface GameTransformer {

    @Mappings({@Mapping(target="gameName", source="gameEntity.gameName"),
               @Mapping(target="rating", source="gameEntity.rating"),
               @Mapping(target="releaseDate", source="gameEntity.releaseDate")})
    GameResponse getGameFromEntity(GameEntity gameEntity);

    GameEntity getEntityFromGame(GameModelRequest gameModel);
}
