package libraryapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


@Configuration
public class ApplicationConfig {

    @Value("${aws.endpoint}")
    private String endpointUrl;

    @Bean
    DynamoDbClient createClient() {
        return DynamoDbClient.builder()
                .region(Region.EU_WEST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    @Bean
    String tableName() {
        return "test";

    }

    public String getEndpointUrl() {
        return endpointUrl;
    }
}
