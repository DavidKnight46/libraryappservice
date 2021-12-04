package libraryapp.controllers.game;

import libraryapp.models.PublisherModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface PublisherController {

    @PostMapping(path = "/addPublisher")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void addPublisher(@RequestBody PublisherModel publisher);

    @DeleteMapping(path = "/deletePublisher/{publisherId}")
    @ResponseStatus(HttpStatus.OK)
    void deletePublisher(@PathVariable(value = "publisherId") String publisherId);
}
