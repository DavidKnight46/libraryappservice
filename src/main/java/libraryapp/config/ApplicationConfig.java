package libraryapp.config;

import libraryapp.aws.AWSRDSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${aws.rds.endpoint}")
    private String endpoint;

    @Bean
    public AWSRDSClient awsRdsClient() {
        AWSRDSClient awsrdsClient = new AWSRDSClient();
        //awsrdsClient.setEndpoint(endpoint);
        //awsrdsClient.setRegion(Region.getRegion(Regions.AP_EAST_1));

        return awsrdsClient;
    }
}
