package libraryapp.api;

import com.google.gson.Gson;
import libraryapp.configuration.RawConfiguration;
import libraryapp.models.modelsV2.GameModelV2;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

@Component
public class ApiClientRawImpl implements ApiClient {

    private final RawConfiguration rawConfiguration;
    private final HttpClient httpClient;

    public ApiClientRawImpl(RawConfiguration rawConfiguration,
                            HttpClient getClient) {
        this.rawConfiguration = rawConfiguration;
        this.httpClient = getClient;
    }

    @Override
    public GameModelV2 getGameDetails(String gameName) throws IOException {

        HttpGet httpGet = new HttpGet(URI.create(String.format(rawConfiguration.getBaseUrl() + "/games/%s?key=%s", gameName, "")));

        HttpResponse execute = httpClient.execute(httpGet);

        Gson gson = new Gson();

        return gson.fromJson(new String(execute.getEntity().getContent().readAllBytes(), Charset.defaultCharset()),
                GameModelV2.class);
    }
}
