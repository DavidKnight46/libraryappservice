package libraryapp.transformer;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.entities.games.GameEntityV2;
import org.mapstruct.Mapper;

@Mapper
public interface GameEntityV2Transformer {

    GameEntityV2Dto fromEntity(GameEntityV2 gameEntityV2Dto);
}
