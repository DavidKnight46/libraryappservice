package libraryapp.service;

import libraryapp.database.GameEntity;
import libraryapp.dto.GameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameToEntity {

    GameToEntity INSTANCE = Mappers.getMapper(GameToEntity.class);

    @Mapping(target = "isPreOrdered", source = "preOrdered")
    GameEntity GameDTOToGameEntity(GameDTO entity);

    @Mapping(target = "preOrdered", source = "isPreOrdered")
    GameDTO GameEntityToGameDTO(GameEntity entity);
}
