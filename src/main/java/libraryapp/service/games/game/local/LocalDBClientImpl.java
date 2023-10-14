package libraryapp.service.games.game.local;

import libraryapp.database.GameEntity;
import libraryapp.database.GamestableRepo;
import libraryapp.dto.GameDTO;
import libraryapp.service.GameToEntity;
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
    public void addAnGame(GameDTO entity) {
        gamestableRepo.save(GameToEntity.INSTANCE.GameDTOToGameEntity(entity));
    }

    @Override
    public Optional<List<GameDTO>> getAllGames() {
        List<GameEntity> list = (List<GameEntity>) gamestableRepo.findAll();
        var f = list.stream().map(e -> createGameDTO(e)).toList();

        return Optional.of(f);
    }

    public GameDTO createGameDTO(GameEntity e){
        return GameToEntity.INSTANCE.GameEntityToGameDTO(e);
    }

    @Override
    public Optional<GameEntity> getAnGame() {
        return Optional.empty();
    }

    @Override
    public void editAnGame(GameDTO game) {
        gamestableRepo.save(GameToEntity.INSTANCE.GameDTOToGameEntity(game));
    }

    @Override
    public void deleteAnGame(GameEntity game) {

    }
}
