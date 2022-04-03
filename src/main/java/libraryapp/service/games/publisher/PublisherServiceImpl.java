package libraryapp.service.games.publisher;

import libraryapp.models.response.PublisherResponse;
import libraryapp.repository.PublisherRepository;
import libraryapp.transformer.PublisherTransformer;
import libraryapp.transformer.PublisherTransformerImpl;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherTransformer publisherTransformer;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
        this.publisherTransformer = new PublisherTransformerImpl();
    }

    @Override
    public void addPublisher(PublisherResponse publisher) {
        publisherRepository.save(publisherTransformer.toPublisherEntity(publisher));
    }

    @Override
    public void deletePublisher(String publisherId) {
        publisherRepository.deleteById(Integer.parseInt(publisherId));
    }
}
