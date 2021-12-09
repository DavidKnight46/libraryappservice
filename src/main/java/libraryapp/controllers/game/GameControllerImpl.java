package libraryapp.controllers.game;

import libraryapp.models.GameModel;
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
    public List<GameModel> getAllGames(@RequestParam(name = "sortBy", required = false) SortBy sortBy,
                                       @RequestParam(name = "order", required = false) Order order,
                                       @RequestParam(name = "userId", required = false) int userId) {
        return service.getCollection(sortBy, order, userId);
    }

    @Override
    public List<GameModel> getAllGameByDeveloper(String developerName) {
        return service.findGamesByDev_Name(developerName);
    }

    @Override
    public void addGameToLibrary(GameModel gameModel,
                                 @RequestParam(name = "userId", required = false) int userId,
                                 @RequestParam(name = "developerId", required = false) int developerId,
                                 @RequestParam(name = "publisherId", required = false) int publisherId) {
        service.addGame(gameModel, userId, developerId, publisherId);
    }
}
