package libraryapp.service.games.game.local;

import libraryapp.database.GameEntity;

import java.util.List;
import java.util.Optional;

public interface LocalDBClient {
    Optional<List<GameEntity>> getAllGames();

    Optional<GameEntity> getAnGame();

    void editAnGame(GameEntity game);

    void deleteAnGame(GameEntity game);
}
