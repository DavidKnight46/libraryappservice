package libraryapp.controllers.game;

import libraryapp.models.request.GameModelRequest;
import libraryapp.models.response.GameResponse;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.service.games.game.GameServices;
import libraryapp.service.games.game.GameServicesImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/game")
public class GameController {

    private final GameServices service;

    public GameController(GameServicesImpl service) {
        this.service = service;
    }

    public String getGame(Model model, @RequestParam int id) {
        //Set<GameModel> collection = service.getCollection();

        model.addAttribute("game", "HZD");

        return "game";
    }

    public List<GameResponse> getAllGames(@RequestParam(name = "sortBy", required = false, defaultValue = "NAME") SortBy sortBy,
                                          @RequestParam(name = "order", required = false, defaultValue = "ASC") Order order,
                                          @RequestParam(name = "userId") int userId) {
        return service.getCollection(sortBy, order, userId);
    }

    public List<GameResponse> getAllGameByDeveloper(String developerName) {
        return service.findGamesByDev_Name(developerName);
    }

    public void addGameToLibrary(GameModelRequest gameModelRequest) {
        service.addGame(gameModelRequest);
    }
}
