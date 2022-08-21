package libraryapp.aws.dynamo;

import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;

import java.util.List;

public interface AWSDynamoDBClientI {
    CreateTableResponse createTable();

    List<AWSDynamoDBModel> getItems(String name);

    void putItem(AWSDynamoDBModel model);

}
