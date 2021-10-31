package libraryapp.controllers.games;

import libraryapp.service.games.GameServicesImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameControllerImpl implements GameController {

    private final GameServicesImpl service;

    public GameControllerImpl(GameServicesImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/getGame")
    public String getGame(Model model, @RequestParam int id) {
        model.addAttribute("game", "HZD");

        return "game";
    }


}
