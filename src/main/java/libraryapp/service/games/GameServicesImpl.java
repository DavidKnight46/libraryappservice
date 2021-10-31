package libraryapp.service.games;

import libraryapp.entities.games.GameEntity;
import libraryapp.models.GameModel;
import libraryapp.repository.GameRepository;
import libraryapp.transformer.GameTransformerImpl;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServicesImpl implements GameServices<GameModel> {

    private final GameRepository gameRepository;
    private GameTransformerImpl gameTransformer;

    public GameServicesImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.gameTransformer = new GameTransformerImpl();
    }

    @Override
    public Set<GameModel> getCollection() {
        Set<GameModel> collect = gameRepository.findAll().stream().collect(Collectors.toSet())
                .stream()
                .map(this::mapToGame)
                .collect(Collectors.toSet());

        return collect;
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
        return gameTransformer.getGameFromEntity(gameEntity);
    }
}
