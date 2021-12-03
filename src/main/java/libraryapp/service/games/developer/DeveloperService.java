package libraryapp.service.games.developer;

import libraryapp.models.DeveloperModel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DeveloperService {

    List<DeveloperModel> getDeveloper();

    void addDeveloper(DeveloperModel developerModel);

    void update(@PathVariable(name = "developerId") String developerId, DeveloperModel developerModel);

    void removeDeveloper(@PathVariable(name = "developerId") String developerId);
}
