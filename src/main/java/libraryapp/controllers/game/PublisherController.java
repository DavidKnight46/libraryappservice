package libraryapp.controllers.game;

import libraryapp.models.response.PublisherResponse;
import libraryapp.service.games.publisher.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public void addPublisher(PublisherResponse publisher) {
        publisherService.addPublisher(publisher);
    }

    public void deletePublisher(String publisherId) {
        publisherService.deletePublisher(publisherId);
    }
}
