package libraryapp.service.games.gameV2;

import libraryapp.models.GameModel;
import org.springframework.lang.NonNull;

import java.io.IOException;

public interface GameServiceV2 {

    GameModel getGameDetails(@NonNull String gameName, String apiKey) throws IOException;
}
