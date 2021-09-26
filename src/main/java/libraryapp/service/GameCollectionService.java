package libraryapp.service;

import libraryapp.models.Game;
import libraryapp.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GameCollectionService implements CollectionService<Game> {

    private final GameRepository gameRepository;

    public GameCollectionService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Set<Game> getCollection() {

        return null;
    }
}
