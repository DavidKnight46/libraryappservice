package libraryapp.controllers.game;

import libraryapp.models.PublisherModel;
import libraryapp.service.games.publisher.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/publisher")
public class PublisherControllerImpl implements PublisherController{

    private final PublisherService publisherService;

    public PublisherControllerImpl(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    public void addPublisher(PublisherModel publisher) {
        publisherService.addPublisher(publisher);
    }

    @Override
    public void deletePublisher(String publisherId) {
        publisherService.deletePublisher(publisherId);
    }
}
