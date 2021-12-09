package libraryapp.controllers.game;

import libraryapp.models.DeveloperModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DeveloperController {

    @GetMapping(path = "/getDevelopers")
    @ResponseStatus(HttpStatus.OK)
    List<DeveloperModel> getDeveloper();

    @PostMapping(path = "/addDeveloper",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void addDeveloper(DeveloperModel developerModel);

    @PutMapping(path = "/editDeveloper/{developerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void update(@PathVariable(name = "developerId") String developerId, @RequestBody DeveloperModel developerModel);

    @DeleteMapping(path = "/deleteDeveloper/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    void removeDeveloper(@PathVariable(name = "developerId") String developerId);
}
