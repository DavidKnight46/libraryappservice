package libraryapp.controllers.gamev2;

import libraryapp.models.GameModel;
import libraryapp.service.games.gameV2.GameServiceV2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/gamev2")
public class GameControllerV2Impl implements GameControllerV2 {

    private final GameServiceV2 gameServiceV2;

    public GameControllerV2Impl(GameServiceV2 gameServiceV2) {
        this.gameServiceV2 = gameServiceV2;
    }

    @Override
    public void getGameDetails(String gameName) throws IOException {
        gameServiceV2.getGameDetails(gameName);

    }

    @Override
    public List<GameModel> getAllGames(String userId) {
        return null;
    }
}
