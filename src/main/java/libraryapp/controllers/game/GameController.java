package libraryapp.controllers.game;

import libraryapp.database.GameEntity;
import libraryapp.service.games.game.local.LocalGameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/gamecontroller")
public class GameController {

    private final LocalGameService localGameService;

    public GameController(LocalGameService localGameService) {
        this.localGameService = localGameService;
    }

    @GetMapping(path = "/getAllGames")
    public Optional<List<GameEntity>> getAllGames() {
        return localGameService.getAllGames();
    }

    @PostMapping(path = "/addGame")
    public void addGame(@RequestBody GameEntity game){
        localGameService.addAGame(game);
    }
}
