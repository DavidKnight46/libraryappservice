package libraryapp.service.games.game.local;

import libraryapp.database.GameEntity;

import java.util.List;
import java.util.Optional;

public class LocalDBClientImpl implements LocalDBClient{
    @Override
    public Optional<List<GameEntity>> getAllGames() {
        return Optional.empty();
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
