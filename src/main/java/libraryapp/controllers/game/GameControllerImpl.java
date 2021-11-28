package libraryapp.controllers.game;

import libraryapp.models.GameModel;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.service.games.game.GameServices;
import libraryapp.service.games.game.GameServicesImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path="/game")
public class GameControllerImpl implements GameController {

    private final GameServices service;

    public GameControllerImpl(GameServicesImpl service) {
        this.service = service;
    }

    @Override
    public String getGame(Model model, @RequestParam int id) {
        //Set<GameModel> collection = service.getCollection();

        model.addAttribute("game", "HZD");

        return "game";
    }

    @Override
    public Set getAllGames(@RequestParam(name = "sortBy", required = false) SortBy sortBy,
                           @RequestParam(name = "order", required = false) Order order){
        return service.getCollection(sortBy, order);
    }

    @Override
    public List<GameModel> getAllGameByDeveloper(String developerName) {
        return service.findGamesByDev_Name(developerName);
    }

}
