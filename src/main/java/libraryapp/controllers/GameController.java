package libraryapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public interface GameController {

    @GetMapping(path = "/getGames")
    String getGame(Model model);
}
