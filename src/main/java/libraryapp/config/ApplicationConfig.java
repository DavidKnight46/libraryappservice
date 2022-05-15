package libraryapp.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${aws.rds.endpoint}")
    private String endpoint;

    @Value("${aws.rds.signingregion}")
    private String signingRegion;

    @Bean
    public AmazonRDS awsRdsClient() {
        return AmazonRDSClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, signingRegion))
                .build();
    }
}
