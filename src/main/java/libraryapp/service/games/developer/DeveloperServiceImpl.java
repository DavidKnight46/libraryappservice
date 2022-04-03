package libraryapp.service.games.developer;

import libraryapp.entities.games.DeveloperEntity;
import libraryapp.models.response.DeveloperResponse;
import libraryapp.repository.DeveloperRepository;
import libraryapp.service.games.game.GameServicesImpl;
import libraryapp.transformer.DeveloperTransformerImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperTransformerImpl developerTransformer;
    private final DeveloperRepository developerRepository;
    private final GameServicesImpl gameServices;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, GameServicesImpl gameServices) {
        this.developerTransformer = new DeveloperTransformerImpl();
        this.developerRepository = developerRepository;
        this.gameServices = gameServices;
    }

    @Override
    public List<DeveloperResponse> getDeveloper() {
        return developerRepository.findAll()
                .stream()
                .map(this::createDeveloperModelBuilder)
                .collect(Collectors.toList());
    }

    @Override
    public void addDeveloper(DeveloperResponse developerResponse) {
        developerRepository.save(developerTransformer.fromDeveloperModel(developerResponse));
    }

    @Override
    public void update(String developerId, DeveloperResponse developerResponse) {
        DeveloperEntity developerEntity = developerTransformer.fromDeveloperModel(developerResponse);

        developerEntity.setId(Integer.parseInt(developerId));

        developerRepository.save(developerEntity);
    }

    @Override
    public void removeDeveloper(String developerId) {
        developerRepository.deleteById(Integer.parseInt(developerId));
    }

    private DeveloperResponse createDeveloperModelBuilder(DeveloperEntity builderModel){
        return developerTransformer.toDeveloperModel(builderModel);
    }
}
