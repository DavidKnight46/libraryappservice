package libraryapp.service.games.game.local;

import libraryapp.database.GameEntity;
import libraryapp.dto.GameDTO;

import java.util.List;
import java.util.Optional;

public interface LocalDBClient {

    void addAnGame(GameDTO entity);

    Optional<List<GameDTO>> getAllGames();

    Optional<GameEntity> getAnGame();

    void editAnGame(GameDTO game);

    void deleteAnGame(GameEntity game);
}
