package libraryapp.transformer;

import libraryapp.entities.games.DeveloperEntity;
import libraryapp.models.DeveloperModel;
import org.mapstruct.Mapper;

@Mapper
public interface DeveloperTransformer {

    DeveloperModel toDeveloperModel(DeveloperEntity developerEntity);
}
