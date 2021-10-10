package libraryapp.service;

import libraryapp.domain.GameEntity;
import libraryapp.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GameCollectionService implements CollectionService<GameEntity> {

    private final GameRepository gameRepository;

    public GameCollectionService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<GameEntity> getCollection() {

        return null;
    }
}
