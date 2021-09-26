package libraryapp.controllers;

import libraryapp.models.Game;
import libraryapp.service.GameCollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class GameController {

    private final GameCollectionService service;

    public GameController(GameCollectionService service) {
        this.service = service;
    }

    @GetMapping(path = "/getGames")
    @ResponseStatus(HttpStatus.OK)
    public Set<Game> getGame(@RequestParam String id){
        return service.getCollection();
    }
}
