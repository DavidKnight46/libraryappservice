package libraryapp.api;

import org.apache.http.HttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.IOException;

public interface ApiClient {

    HttpResponse getGameDetails(@NonNull String apiKey, @Nullable String gameNme) throws IOException;
}

