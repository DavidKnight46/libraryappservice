package libraryapp.service.games.game;

import libraryapp.entities.games.GameEntity;
import libraryapp.models.GameModel;
import libraryapp.models.PublisherModel;
import libraryapp.repository.GameRepository;
import libraryapp.transformer.DeveloperTransformerImpl;
import libraryapp.transformer.GameTransformerImpl;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServicesImpl implements GameServices<GameModel> {

    private final GameRepository gameRepository;
    private GameTransformerImpl gameTransformer;
    private DeveloperTransformerImpl developerTransformer;

    public GameServicesImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.gameTransformer = new GameTransformerImpl();
        this.developerTransformer = new DeveloperTransformerImpl();
    }

    @Override
    public Set<GameModel> getCollection() {
        return gameRepository.findAll().stream().collect(Collectors.toSet())
                .stream()
                .map(this::mapToGame)
                .collect(Collectors.toSet());
    }

    @Override
    public GameModel getItem(int id) {
       return gameTransformer.getGameFromEntity(gameRepository.findById(id).orElseThrow());
    }

    @Override
    public GameModel findGameByDev() {
        return null;
    }

    private GameModel mapToGame(GameEntity gameEntity) {
        GameModel gameModel = gameTransformer.getGameFromEntity(gameEntity);

        gameModel.setDeveloper(developerTransformer.toDeveloperModel(gameEntity.getDeveloper()));
        gameModel.setPublisher(new PublisherModel(gameEntity.getPublisher().getName()));

        return gameModel;
    }
}
