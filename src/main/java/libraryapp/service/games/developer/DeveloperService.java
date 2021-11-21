package libraryapp.service.games.developer;

import libraryapp.models.DeveloperModelBuilder;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DeveloperService {

    List<DeveloperModelBuilder> getDeveloper();

    void addDeveloper(DeveloperModelBuilder developerModel);

    void update(@PathVariable(name = "developerId") String developerId, DeveloperModelBuilder developerModel);

    void removeDeveloper(@PathVariable(name = "developerId") String developerId);
}
