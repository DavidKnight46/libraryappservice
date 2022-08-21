package libraryapp.aws.dynamo;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

public class AWSDynamoDBClient implements AWSDynamoDBClientI{

    private final String tableName;

    public AWSDynamoDBClient(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public CreateTableResponse createTable(DynamoDbClient dynamoDbClient) {
        return dynamoDbClient.createTable(CreateTableRequest.builder()
                .tableName(tableName)
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
    public String getItem(DynamoDbClient dynamoDbClient, String userName, String itemToGet) {
        Map<String, AttributeValue> keyMap = new HashMap();
        keyMap.put("UserName", AttributeValue.fromS(userName));

        GetItemRequest getItemRequest = GetItemRequest.builder()
                .tableName(tableName)
                .key(keyMap)
                .attributesToGet()
                .build();

        return dynamoDbClient.getItem(getItemRequest).item().get("itemToGet").s();

    }

    @Override
    public void putItem(DynamoDbClient dynamoDbClient, AWSDynamoDBModel model) {
        Map<String, AttributeValue> map = new HashMap();
        map.put("UserName", AttributeValue.fromS(model.getUserName()));
        map.put("Genre", AttributeValue.fromS(model.getGenre()));
        map.put("GameName", AttributeValue.fromS(model.getName()));
        map.put("Platform", AttributeValue.fromS(model.getPlatform()));

        try {
            dynamoDbClient.putItem(PutItemRequest.builder().tableName(this.tableName).item(map).build());
        }catch (Exception e){
            e.getMessage();
        }
    }
}
