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
public class DeveloperControllerImpl implements DeveloperController {


    private final DeveloperService developerService;

    public DeveloperControllerImpl(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @Override
    public List<DeveloperResponse> getDeveloper() {
        return developerService.getDeveloper();
    }

    @Override
    @Transactional
    public void addDeveloper(@RequestBody DeveloperResponse developerResponse) {
        developerService.addDeveloper(developerResponse);
    }

    @Override
    public void update(String developerId, @RequestBody DeveloperResponse developerResponse) {
        developerService.update(developerId, developerResponse);
    }

    @Override
    public void removeDeveloper(String developerId) {
        developerService.removeDeveloper(developerId);
    }
}
