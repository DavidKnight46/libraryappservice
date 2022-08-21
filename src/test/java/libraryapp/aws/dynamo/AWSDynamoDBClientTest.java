package libraryapp.aws.dynamo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

class AWSDynamoDBClientTest {

    private AWSDynamoDBClientI underTest;

    @BeforeEach
    public void init(){
        underTest = new AWSDynamoDBClient("test");
    }

    @Test
    public void foo(){
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(Region.EU_WEST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        //underTest.createTable(dynamoDbClient);

        underTest.putItem(dynamoDbClient, new AWSDynamoDBModel("Horizon: Forbidden West",
                "ARPG",
                "PS5",
                "DavidKnight"));
    }
}