package libraryapp.controllers.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.AWSDynamoDBModel;
import libraryapp.service.games.game.GameServiceImplV2;
import libraryapp.service.games.game.GameServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.OnError;
import java.util.List;

@RestController
@RequestMapping(path = "/gamecontroller/v2")
public class GameV2Controller {

    private final GameServices gameServices;

    public GameV2Controller(GameServiceImplV2 gameServices) {
        this.gameServices = gameServices;
    }

    @PostMapping(path = "/createUserGameTable/{tableName}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createUserGameTable(@PathVariable(value = "tableName") String tableName){
        return this.gameServices.createUserGameTable(tableName);
    }

    @GetMapping(path = "/getAllGames/{userName}")
    public List<AWSDynamoDBModel> getAllGames(@PathVariable(value = "userName") String userName) {
        return gameServices.getCollection(userName);
    }

    @PostMapping(path = "/addNewGame/{userName}")
    public void addGame(@RequestBody GameEntityV2Dto gameModelRequest,
                        @PathVariable(value = "userName") String userName) {
        gameServices.addGame(gameModelRequest, userName);
    }

    @PutMapping(path = "/updateGame")
    public void updateGame(@RequestBody GameEntityV2Dto gameModelRequest) {
        //gameServices.editItem(gameModelRequest);
    }

    @DeleteMapping(path = "/deleteGame")
    public void deleteGame(@RequestBody GameEntityV2Dto gameEntityV2Dto) {
        //gameServices.deleteItem(gameEntityV2Dto);
    }
}
