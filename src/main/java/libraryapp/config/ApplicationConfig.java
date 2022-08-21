package libraryapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {

    @Value("${aws.rds.endpoint}")
    private String endpoint;

    @Value("${aws.rds.signingregion}")
    private String signingRegion;

    @Value("${aws.endpoint}")
    private String endpointUrl;

    public String getEndpoint() {
        return endpoint;
    }

    public String getSigningRegion() {
        return signingRegion;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }
}
