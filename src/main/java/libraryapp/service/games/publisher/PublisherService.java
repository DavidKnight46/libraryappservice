package libraryapp.service.games.publisher;

import libraryapp.models.response.PublisherResponse;

public interface PublisherService {

    void addPublisher(PublisherResponse publisher);

    void deletePublisher(String publisherId);
}
