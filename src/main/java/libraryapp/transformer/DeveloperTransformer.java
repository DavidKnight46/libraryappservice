package libraryapp.transformer;

import libraryapp.entities.games.DeveloperEntity;
import libraryapp.models.response.DeveloperResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper
public interface DeveloperTransformer {

    @Mappings({@Mapping(source = "developerEntity.name", target= "name")})
    DeveloperResponse toDeveloperModel(DeveloperEntity developerEntity);

    DeveloperEntity fromDeveloperModel(DeveloperResponse developerResponse);
}
