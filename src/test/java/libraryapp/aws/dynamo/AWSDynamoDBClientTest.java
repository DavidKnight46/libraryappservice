package libraryapp.aws.dynamo;

import libraryapp.config.ApplicationConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
class AWSDynamoDBClientTest {

    private AWSDynamoDBClientI underTest;

    private ApplicationConfig config;

    @MockBean
    private DynamoDbClient createClient;

    @BeforeEach
    public void init(){
        underTest = new AWSDynamoDBClient("test", createClient);
    }

    @Test
    public void foo(){
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(Region.EU_WEST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        //AWSDynamoDBModel item = underTest.getItem(dynamoDbClient, "DavidKnight", "");

        //assertThat(item.getGenre()).isEqualTo("ARPG");
        //assertThat(item.getPlatform()).isEqualTo("PS5");
    }
}