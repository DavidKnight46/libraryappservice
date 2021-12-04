package libraryapp.service.games.publisher;

import libraryapp.models.PublisherModel;

public interface PublisherService {

    void addPublisher(PublisherModel publisher);

    void deletePublisher(String publisherId);
}
