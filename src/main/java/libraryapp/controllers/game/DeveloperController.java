package libraryapp.controllers.game;

import libraryapp.models.response.DeveloperResponse;
import libraryapp.service.games.developer.DeveloperService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {


    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public List<DeveloperResponse> getDeveloper() {
        return developerService.getDeveloper();
    }

    @Transactional
    public void addDeveloper(@RequestBody DeveloperResponse developerResponse) {
        developerService.addDeveloper(developerResponse);
    }

    public void update(String developerId, @RequestBody DeveloperResponse developerResponse) {
        developerService.update(developerId, developerResponse);
    }

    public void removeDeveloper(String developerId) {
        developerService.removeDeveloper(developerId);
    }
}
