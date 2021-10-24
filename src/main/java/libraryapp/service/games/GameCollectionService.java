package libraryapp.service.games;

import libraryapp.repository.entities.games.GameEntity;
import libraryapp.repository.games.GameRepository;
import libraryapp.service.CollectionService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameCollectionService implements CollectionService<GameEntity> {

    private final GameRepository gameRepository;

    public GameCollectionService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<GameEntity> getCollection() {
        return gameRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public GameEntity getItem(int id) {
        GameEntity gameEntity = gameRepository.findById(id).orElseThrow();

        return gameEntity;
    }
}
