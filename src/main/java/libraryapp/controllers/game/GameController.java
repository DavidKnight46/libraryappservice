package libraryapp.controllers.game;

import libraryapp.database.GameEntity;
import libraryapp.service.games.game.local.LocalGameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/gamecontroller")
public class GameController {

    private final LocalGameService localGameService;

    public GameController(LocalGameService localGameService) {
        this.localGameService = localGameService;
    }

    @GetMapping(path = "/foo")
    public Optional<List<GameEntity>> getAllGames() {
        return localGameService.getAllGames();
    }
}
