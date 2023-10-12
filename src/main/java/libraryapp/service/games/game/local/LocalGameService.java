package libraryapp.service.games.game.local;

import libraryapp.database.GameEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalGameService {

    private final LocalDBClient localDBClient;

    public  LocalGameService(LocalDBClientImpl localDBClient){
        this.localDBClient = localDBClient;
    }

    public Optional<List<GameEntity>> getAllGames(){
        return localDBClient.getAllGames();
    }

    public void addAGame(GameEntity entity){
        this.localDBClient.addAnGame(entity);
    }
}
