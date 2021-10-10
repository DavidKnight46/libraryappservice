package libraryapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


public interface GameController {

    @GetMapping(path = "/getGames")
    String getGame(Model model);
}
