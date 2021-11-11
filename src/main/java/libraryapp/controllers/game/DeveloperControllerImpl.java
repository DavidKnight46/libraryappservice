package libraryapp.controllers.game;

import libraryapp.models.DeveloperModelBuilder;
import libraryapp.service.games.DeveloperService;
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
    public List<DeveloperModelBuilder> getDeveloper() {
        return developerService.getDeveloper();
    }

    @Override
    @Transactional
    public void addDeveloper(@RequestBody DeveloperModelBuilder developerModel) {
        developerService.addDeveloper(developerModel);
    }

    @Override
    public void update(String developerId, @RequestBody DeveloperModelBuilder developerModel) {
        developerService.update(developerId, developerModel);
    }

    @Override
    public void removeDeveloper(String developerId) {
        developerService.removeDeveloper(developerId);
    }
}
