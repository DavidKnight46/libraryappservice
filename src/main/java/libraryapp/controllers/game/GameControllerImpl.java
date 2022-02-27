package libraryapp.controllers.game;

import libraryapp.models.response.GameResponse;
import libraryapp.models.request.GameModelRequest;
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
    public List<GameResponse> getAllGames(@RequestParam(name = "sortBy", required = false, defaultValue = "NAME") SortBy sortBy,
                                          @RequestParam(name = "order", required = false, defaultValue = "ASC") Order order,
                                          @RequestParam(name = "userId") int userId) {
        return service.getCollection(sortBy, order, userId);
    }

    @Override
    public List<GameResponse> getAllGameByDeveloper(String developerName) {
        return service.findGamesByDev_Name(developerName);
    }

    @Override
    public void addGameToLibrary(GameModelRequest gameModelRequest) {
        service.addGame(gameModelRequest);
    }
}
