package libraryapp.transformer;

import libraryapp.entities.games.PublisherEntity;
import libraryapp.models.response.PublisherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PublisherTransformer {

    @Mappings({@Mapping(source = "publisherResponse.name", target = "name")})
    PublisherEntity toPublisherEntity(PublisherResponse publisherResponse);

    PublisherResponse fromPublisherEntity(PublisherEntity publisherEntity);
}
