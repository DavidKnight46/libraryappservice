package libraryapp.controllers.gamev2;

import libraryapp.models.GameModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface GameController {

    @GetMapping(path = "/details/{gameName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void getGameDetails(@PathVariable(value = "gameName") String gameName);

    @GetMapping(path = "/getAllGames")
    @ResponseStatus(HttpStatus.OK)
    List<GameModel> getAllGames(@RequestParam String userId);
}
