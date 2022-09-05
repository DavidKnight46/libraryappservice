package libraryapp.aws.dynamo;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class AWSDynamoDBClientUser implements AWSDynamoDBClientUserI {

    private final DynamoDbClient dynamoDbClient;

    public AWSDynamoDBClientUser(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    @Override
    public CreateTableResponse createTable() {
        return dynamoDbClient.createTable(CreateTableRequest.builder()
                .tableName("users")
                .attributeDefinitions(
                        AttributeDefinition.builder()
                                .attributeName("UserName")
                                .attributeType("S")
                                .build())
                .keySchema(KeySchemaElement.builder()
                        .keyType(KeyType.HASH)
                        .attributeName("UserName")
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(10L).writeCapacityUnits(10L).build())
                .build());
    }

    @Override
    public boolean checkUser(String name, String password) {
        Map<String, AttributeValue> keyMap = new HashMap();
        keyMap.put("username",AttributeValue.fromS(name));

        GetItemRequest getItemRequest = GetItemRequest.builder()
                .tableName("users")
                .key(keyMap)
                .attributesToGet("Password")
                .build();

        GetItemResponse itemResponse = dynamoDbClient.getItem(getItemRequest);

        boolean isValidUser = itemResponse.item().get("Password").s().contentEquals(password);

        return isValidUser;
    }

    @Override
    public void createUser(String username, String password) {
        Map<String, AttributeValue> map = new HashMap();
        map.put("username", AttributeValue.fromS(username));
        map.put("Password", AttributeValue.fromS(password));

        try {
            dynamoDbClient.putItem(PutItemRequest.builder().tableName("users").item(map).build());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}