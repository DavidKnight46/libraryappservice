package libraryapp.service.games.developer;

import libraryapp.models.response.DeveloperResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DeveloperService {

    List<DeveloperResponse> getDeveloper();

    void addDeveloper(DeveloperResponse developerResponse);

    void update(@PathVariable(name = "developerId") String developerId, DeveloperResponse developerResponse);

    void removeDeveloper(@PathVariable(name = "developerId") String developerId);
}
