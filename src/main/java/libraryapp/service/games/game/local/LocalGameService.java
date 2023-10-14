package libraryapp.service.games.game.local;

import libraryapp.dto.GameDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalGameService {

    private final LocalDBClient localDBClient;

    public  LocalGameService(LocalDBClientImpl localDBClient){
        this.localDBClient = localDBClient;
    }

    public Optional<List<GameDTO>> getAllGames(){
        return localDBClient.getAllGames();
    }

    public void addAGame(GameDTO entity){
        this.localDBClient.addAnGame(entity);
    }

    public void editAnGame(GameDTO entity){
        this.localDBClient.editAnGame(entity);
    }
}
