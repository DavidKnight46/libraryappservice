package libraryapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RawConfiguration {

    @Value("${libraryservice.raw.url}")
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }
}
