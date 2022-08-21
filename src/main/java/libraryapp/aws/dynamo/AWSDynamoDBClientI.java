package libraryapp.aws.dynamo;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;

public interface AWSDynamoDBClientI {
    CreateTableResponse createTable(DynamoDbClient dynamoDbClient);

    String getItem(DynamoDbClient dynamoDbClient, String name, String itemToGet);

    void putItem(DynamoDbClient dynamoDbClient, AWSDynamoDBModel model);
}
