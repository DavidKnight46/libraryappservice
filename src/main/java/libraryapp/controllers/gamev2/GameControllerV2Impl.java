package libraryapp.controllers.gamev2;

import libraryapp.models.GameModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gamev2")
public class GameControllerV2Impl implements GameControllerV2 {

    @Override
    public void getGameDetails(String gameName) {

    }

    @Override
    public List<GameModel> getAllGames(String userId) {
        return null;
    }
}
