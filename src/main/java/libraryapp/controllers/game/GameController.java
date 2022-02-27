package libraryapp.controllers.game;

import libraryapp.models.response.GameResponse;
import libraryapp.models.request.GameModelRequest;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface GameController {

    @GetMapping(path = "/getGame")
    String getGame(Model model, @RequestParam int id);

    @GetMapping(path = "/getAllGames")
    List<GameResponse> getAllGames(@RequestParam(name = "sortBy", required = false) SortBy sortBy,
                                   @RequestParam(name = "order", required = false) Order order,
                                   @RequestParam(name = "userId", required = false) int userId);

    @GetMapping(path = "/getAllGames/{developerName}")
    List<GameResponse> getAllGameByDeveloper(@PathVariable(value = "developerName") String developerName);

    @PostMapping(path = "/addGame")
    void addGameToLibrary(@RequestBody GameModelRequest gameModel);
}
