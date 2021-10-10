package libraryapp.controllers;

import libraryapp.service.GameCollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class GameControllerImpl implements GameController {

    private final GameCollectionService service;

    public GameControllerImpl(GameCollectionService service) {
        this.service = service;
    }

    @GetMapping(path = "/getGames")
    public String getGame(Model model){

        model.addAttribute("games", "HZD");

        return "games";
    }
}
