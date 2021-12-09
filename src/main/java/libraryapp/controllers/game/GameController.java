package libraryapp.controllers.game;

import libraryapp.models.GameModel;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


public interface GameController {

    @GetMapping(path = "/getGame")
    String getGame(Model model, @RequestParam int id);

    @GetMapping(path = "/getAllGames")
    List<GameModel> getAllGames(@RequestParam(name = "sortBy", required = false) SortBy sortBy,
                                @RequestParam(name = "order", required = false) Order order,
                                @RequestParam(name = "userId", required = false) int userId);

    @GetMapping(path = "/getAllGames/{developerName}")
    List<GameModel> getAllGameByDeveloper(@PathVariable(value = "developerName") String developerName);

    @PostMapping(path = "/addGame")
    void addGameToLibrary(@RequestBody GameModel gameModel,
                          @RequestParam(name = "userId", required = false) int userId,
                          @RequestParam(name = "developerId", required = false) int developerId,
                          @RequestParam(name = "publisherId", required = false) int publisherId);
}
