package libraryapp.controllers.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.request.GameModelRequest;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
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

    @GetMapping(path = "/getAllGames/{id}")
    public List<GameEntityV2Dto> getAllGames(@PathVariable(value = "id") String id) {
        return gameServices.getCollection(SortBy.NAME, Order.DESC, Integer.parseInt(id));
    }

    @PostMapping(path = "/addNewGame/{id}")
    public void addGame(@RequestBody GameEntityV2Dto gameModelRequest,
                        @PathVariable(value = "id") Integer id) {
        gameServices.addGame(gameModelRequest, id);
    }

    @PutMapping(path = "/updateGame")
    public void updateGame(@RequestBody GameEntityV2Dto gameModelRequest) {
        gameServices.editItem(gameModelRequest);
    }

    @DeleteMapping(path = "/deleteGame")
    public void deleteGame(GameModelRequest gameModelRequest) {
    }
}
