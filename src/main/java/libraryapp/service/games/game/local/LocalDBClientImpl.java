package libraryapp.service.games.game.local;

import libraryapp.database.GameEntity;
import libraryapp.database.GamestableRepo;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LocalDBClientImpl implements LocalDBClient{

    private final GamestableRepo gamestableRepo;

    public LocalDBClientImpl(GamestableRepo gamestableRepo){
        this.gamestableRepo = gamestableRepo;
    }

    @Override
    public void addAnGame(GameEntity entity) {
        gamestableRepo.save(entity);
    }

    @Override
    public Optional<List<GameEntity>> getAllGames() {
        return Optional.ofNullable((List<GameEntity>) gamestableRepo.findAll());
    }

    @Override
    public Optional<GameEntity> getAnGame() {
        return Optional.empty();
    }

    @Override
    public void editAnGame(GameEntity game) {

    }

    @Override
    public void deleteAnGame(GameEntity game) {

    }
}
