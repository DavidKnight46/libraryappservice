package libraryapp.transformer;

import libraryapp.entities.games.PublisherEntity;
import libraryapp.models.PublisherModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PublisherTransformer {

    @Mappings({@Mapping(source = "publisherModel.name", target= "name")})
    PublisherEntity toPublisherEntity(PublisherModel publisherModel);

    PublisherModel fromPublisherEntity(PublisherEntity publisherEntity);
}
