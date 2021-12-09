package libraryapp.api;

import org.springframework.lang.NonNull;

public interface ApiClient {

    void getGameDetails(@NonNull String apiKey, @NonNull String slugName, String id);
}
