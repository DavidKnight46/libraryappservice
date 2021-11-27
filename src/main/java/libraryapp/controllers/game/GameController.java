package libraryapp.controllers.game;

import libraryapp.models.GameModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;


public interface GameController {

    @GetMapping(path = "/getGame")
    String getGame(Model model, @RequestParam int id);

    @GetMapping(path = "/getAllGames")
    Set getAllGames();

    @GetMapping(path = "/getAllGamesByDeveloper/{developerName}")
    List<GameModel> getAllGameByDeveloper(@PathVariable(value = "developerName") String developerName);
}