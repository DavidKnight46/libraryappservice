package libraryapp.controllers.game;

import libraryapp.models.AWSDynamoDBModel;
import libraryapp.service.games.game.GameServiceImplV2;
import libraryapp.service.games.game.GameServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gamecontroller/v2")
public class GameV2Controller {

    private final GameServices gameServices;

    public GameV2Controller(GameServiceImplV2 gameServices) {
        this.gameServices = gameServices;
    }

    @GetMapping(path = "/getAllGames/{userName}")
    public List<AWSDynamoDBModel> getAllGames(@PathVariable(value = "userName") String userName) {
        return gameServices.getCollection(userName);
    }

    @PostMapping(path = "/addNewGame")
    public void addGame(@RequestBody AWSDynamoDBModel gameModel) {
        gameServices.addItem(gameModel);
    }

    @PutMapping(path = "/updateGame")
    public void updateGame(@RequestBody AWSDynamoDBModel gameModelRequest) {
        gameServices.editItem(gameModelRequest);
    }

    @DeleteMapping(path = "/deleteGame")
    public void deleteGame(@RequestParam(value = "userName") String userName, @RequestParam(value = "gameName") String gameName) {
        gameServices.deleteGame(userName, gameName);
    }
}
