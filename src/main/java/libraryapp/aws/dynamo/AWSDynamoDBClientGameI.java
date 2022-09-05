package libraryapp.aws.dynamo;

import libraryapp.models.AWSDynamoDBModel;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;

import java.util.List;

public interface AWSDynamoDBClientGameI {
    CreateTableResponse createTable(String tableName);

    List<AWSDynamoDBModel> getItems(String name);

    void putItem(AWSDynamoDBModel model, String tableName);

}