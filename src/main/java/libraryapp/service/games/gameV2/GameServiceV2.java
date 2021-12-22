package libraryapp.service.games.gameV2;

import libraryapp.models.modelsV2.GameModelV2;
import org.springframework.lang.NonNull;

import java.io.IOException;

public interface GameServiceV2 {

    GameModelV2 getGameDetails(@NonNull String gameName) throws IOException;
}
