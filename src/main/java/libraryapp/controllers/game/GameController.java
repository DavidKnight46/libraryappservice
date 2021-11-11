package libraryapp.controllers.game;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public interface GameController {

    @GetMapping(path = "/getGame")
    String getGame(Model model, int id);
}
