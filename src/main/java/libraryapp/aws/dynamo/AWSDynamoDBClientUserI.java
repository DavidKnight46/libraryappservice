package libraryapp.aws.dynamo;

import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;

public interface AWSDynamoDBClientUserI {
    CreateTableResponse createTable();

    boolean checkUser(String name, String password);

    void createUser(String username, String password);
}
