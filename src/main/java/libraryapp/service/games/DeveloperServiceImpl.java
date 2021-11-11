package libraryapp.service.games;

import libraryapp.entities.games.DeveloperEntity;
import libraryapp.models.DeveloperModelBuilder;
import libraryapp.repository.DeveloperRepository;
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
    public List<DeveloperModelBuilder> getDeveloper() {
        return developerRepository.findAll()
                .stream()
                .map(this::createDeveloperModelBuilder)
                .collect(Collectors.toList());
    }

    @Override
    public void addDeveloper(DeveloperModelBuilder developerModel) {
        developerRepository.save(developerTransformer.fromDeveloperModel(developerModel));
    }

    @Override
    public void update(String developerId, DeveloperModelBuilder developerModel) {
        DeveloperEntity developerEntity = developerTransformer.fromDeveloperModel(developerModel);

        developerEntity.setId(Integer.parseInt(developerId));

        developerRepository.save(developerEntity);
    }

    @Override
    public void removeDeveloper(String developerId) {
        developerRepository.deleteById(Integer.parseInt(developerId));
    }

    private DeveloperModelBuilder createDeveloperModelBuilder(DeveloperEntity builderModel){
        return developerTransformer.toDeveloperModel(builderModel);
    }
}
