package libraryapp.service.games.gameV2;

import libraryapp.api.ApiClient;
import libraryapp.api.ApiClientRawImpl;
import libraryapp.configuration.RawConfiguration;
import libraryapp.models.GameModel;
import libraryapp.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GameServiceV2Impl implements GameServiceV2 {

    private final RawConfiguration rawConfiguration;
    private final GameRepository gameRepository;
    private final ApiClient apiClient;

    public GameServiceV2Impl(RawConfiguration rawConfiguration,
                             GameRepository gameRepository,
                             ApiClientRawImpl apiClient) {
        this.rawConfiguration = rawConfiguration;
        this.gameRepository = gameRepository;
        this.apiClient = apiClient;
    }

    @Override
    public GameModel getGameDetails(String gameName, String apiKey) throws IOException {

        apiClient.getGameDetails(gameName, apiKey);
        return null;
    }
}
