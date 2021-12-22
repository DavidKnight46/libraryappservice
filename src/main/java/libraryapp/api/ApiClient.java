package libraryapp.api;

import libraryapp.models.modelsV2.GameModelV2;
import org.springframework.lang.Nullable;

import java.io.IOException;

public interface ApiClient {

    GameModelV2 getGameDetails(@Nullable String gameNme) throws IOException;
}

