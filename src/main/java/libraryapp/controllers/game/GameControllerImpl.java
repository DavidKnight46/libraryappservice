package libraryapp.controllers.game;

import libraryapp.models.GameModel;
import libraryapp.service.games.GameServices;
import libraryapp.service.games.GameServicesImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController("/game")
public class GameControllerImpl implements GameController {

    private final GameServices service;

    public GameControllerImpl(GameServicesImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/getGame")
    public String getGame(Model model, @RequestParam int id) {
        Set<GameModel> collection = service.getCollection();

        model.addAttribute("game", "HZD");

        return "game";
    }

    @GetMapping(path = "/getAllGames")
    @ResponseBody
    public Set getAllGames(){
        return service.getCollection();
    }

}
