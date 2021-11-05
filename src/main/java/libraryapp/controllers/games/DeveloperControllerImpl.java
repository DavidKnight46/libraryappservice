package libraryapp.controllers.games;

import libraryapp.entities.games.DeveloperEntity;
import libraryapp.models.DeveloperModelBuilder;
import libraryapp.repository.DeveloperRepository;
import libraryapp.service.games.GameServicesImpl;
import libraryapp.transformer.DeveloperTransformerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Controller
public class DeveloperControllerImpl implements DeveloperController {

    private final DeveloperTransformerImpl developerTransformer;
    private final DeveloperRepository developerRepository;
    private final GameServicesImpl gameServices;

    public DeveloperControllerImpl(DeveloperRepository developerRepository, GameServicesImpl gameServices) {
        this.developerRepository = developerRepository;
        this.gameServices = gameServices;
        this.developerTransformer = new DeveloperTransformerImpl();
    }

    @Override
    @Transactional
    public void addDeveloper(@RequestBody DeveloperModelBuilder developerModel) {
        DeveloperEntity developerEntity = developerTransformer.fromDeveloperModel(developerModel);

        developerRepository.save(developerEntity);
    }

}
