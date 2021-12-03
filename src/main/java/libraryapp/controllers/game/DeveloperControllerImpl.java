package libraryapp.controllers.game;

import libraryapp.models.DeveloperModel;
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
    public List<DeveloperModel> getDeveloper() {
        return developerService.getDeveloper();
    }

    @Override
    @Transactional
    public void addDeveloper(@RequestBody DeveloperModel developerModel) {
        developerService.addDeveloper(developerModel);
    }

    @Override
    public void update(String developerId, @RequestBody DeveloperModel developerModel) {
        developerService.update(developerId, developerModel);
    }

    @Override
    public void removeDeveloper(String developerId) {
        developerService.removeDeveloper(developerId);
    }
}
