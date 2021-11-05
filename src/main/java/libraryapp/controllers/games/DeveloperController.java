package libraryapp.controllers.games;

import libraryapp.models.DeveloperModelBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface DeveloperController {

    @PostMapping(path = "/addDeveloper",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void addDeveloper(DeveloperModelBuilder developerModel);
}
