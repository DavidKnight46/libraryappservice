package libraryapp.service.games.gameV2;

import libraryapp.api.ApiClient;
import libraryapp.api.ApiClientRawImpl;
import libraryapp.models.modelsV2.GameModelV2;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GameServiceV2Impl implements GameServiceV2 {

    private final ApiClient apiClient;

    public GameServiceV2Impl(ApiClientRawImpl apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public GameModelV2 getGameDetails(String gameName) throws IOException {
        return apiClient.getGameDetails(gameName);
    }
}
