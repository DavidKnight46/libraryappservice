package libraryapp.api;

import libraryapp.configuration.RawConfiguration;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;

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
    public HttpResponse getGameDetails(String apiKey, String gameName) throws IOException {

        HttpGet httpGet = new HttpGet(URI.create(String.format(rawConfiguration.getBaseUrl() + "/game/%s/?key=%s", gameName, apiKey)));

        return httpClient.execute(httpGet);
    }
}
