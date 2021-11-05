package libraryapp.transformer;

import libraryapp.entities.games.DeveloperEntity;
import libraryapp.models.DeveloperModelBuilder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper
public interface DeveloperTransformer {

    @Mappings({@Mapping(source = "developerEntity.name", target= "name")})
    DeveloperModelBuilder toDeveloperModel(DeveloperEntity developerEntity);

    //@Mappings({@Mapping(source = "developerModel.name", target= "name")})
    DeveloperEntity fromDeveloperModel(DeveloperModelBuilder developerModel);
}
