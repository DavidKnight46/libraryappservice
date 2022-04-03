package libraryapp.controllers.game;

import libraryapp.models.request.GameModelRequest;
import libraryapp.models.response.GameResponse;
import libraryapp.service.games.game.GameServices;
import libraryapp.service.games.game.GameServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gamecontroller/v2")
public class GameV2Controller {

    private final GameServices gameServices;

    public GameV2Controller(GameServicesImpl gameServices) {
        this.gameServices = gameServices;
    }

    @GetMapping(path = "/getAllGames")
    public List<GameResponse> getAllGames(){

        return null;
    }

    @PostMapping(path = "/addNewGame")
    public void addGame(GameModelRequest gameModelRequest){}

    @PutMapping(path = "/updateGame")
    public void updateGame(GameModelRequest gameModelRequest){}

    @DeleteMapping(path = "/deleteGame")
    public void deleteGame(GameModelRequest gameModelRequest){}
}
