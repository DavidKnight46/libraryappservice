package libraryapp.aws.dynamo;

import libraryapp.models.AWSDynamoDBModel;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AWSDynamoDBClientGame implements AWSDynamoDBClientGameI {

    private final String tableName;
    private final DynamoDbClient dynamoDbClient;

    public AWSDynamoDBClientGame(String tableName, DynamoDbClient createClient) {
        this.tableName = tableName;
        this.dynamoDbClient = createClient;
    }

    @Override
    public CreateTableResponse createTable() {
        return dynamoDbClient.createTable(CreateTableRequest.builder()
                .tableName(this.tableName)
                .attributeDefinitions(
                        AttributeDefinition.builder()
                                .attributeName("GameName")
                                .attributeType("S")
                                .build(),
                        AttributeDefinition.builder()
                                .attributeName("userName")
                                .attributeType("S")
                                .build())
                .keySchema(KeySchemaElement.builder()
                                .keyType(KeyType.HASH)
                                .attributeName("GameName")
                                .build(),
                        KeySchemaElement.builder()
                                .keyType(KeyType.RANGE)
                                .attributeName("userName")
                                .build())
                .provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(10L).writeCapacityUnits(10L).build())
                .build());
    }

    @Override
    public List<AWSDynamoDBModel> getItems(String userName) {
        Map<String, AttributeValue> map = new HashMap();
        map.put(":val", AttributeValue.fromS(userName));

        ScanResponse scanResponse = dynamoDbClient.scan(ScanRequest.builder()
                .tableName(this.tableName)
                .filterExpression("userName = :val")
                .expressionAttributeValues(map)
                .build());

        return scanResponse.items().stream().map(this::mapToAWSDynamoDBModel).collect(Collectors.toList());
    }

    @Override
    public void putItem(AWSDynamoDBModel model) {
        boolean hasTable = dynamoDbClient.listTables().tableNames().contains(tableName);

        if (!hasTable) {
            createTable();
        }

        try {
            dynamoDbClient.putItem(PutItemRequest.builder()
                    .tableName(this.tableName)
                    .item(createAttributeMap(model))
                    .build());

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void updateItem(AWSDynamoDBModel model) {
        Map<String, AttributeValue> keyMap = new HashMap();
        keyMap.put("GameName", AttributeValue.fromS(model.getGameName()));
        keyMap.put("userName", AttributeValue.fromS(model.getUserName()));

        UpdateItemRequest updateItemRequest = UpdateItemRequest.builder()
                .tableName(this.tableName)
                .key(keyMap)
                .attributeUpdates(createAttributeMapUpdate(model))
                .build();

        dynamoDbClient.updateItem(updateItemRequest);
    }

    @Override
    public void deleteItem(String userName, String gameName) {
        HashMap<String, AttributeValue> keyMap = new HashMap();
        createAttributeValueMap(keyMap, "GameName", gameName);
        createAttributeValueMap(keyMap, "userName", userName);

        DeleteItemRequest deleteItemRequest = DeleteItemRequest.builder()
                .tableName(this.tableName)
                .key(keyMap)
                .build();

        dynamoDbClient.deleteItem(deleteItemRequest);
    }

    private static void createAttributeValueMap(Map<String, AttributeValue> keyMap, String GameName, String model) {
        keyMap.put(GameName, AttributeValue.fromS(model));
    }

    private Map<String, AttributeValueUpdate> createAttributeMapUpdate(AWSDynamoDBModel model) {
        Map<String, AttributeValueUpdate> map = new HashMap();

        map.put("Genre", createAttributeValue(model.getGameGenre()));
        map.put("Platform", createAttributeValue(model.getPlatform()));
        map.put("gameRating", createAttributeValue(Float.toString(model.getGameRating())));
        map.put("releaseDate", createAttributeValue(model.getReleaseDate().toString()));
        map.put("isPreOrdered", createAttributeValue(model.getIsPreOrdered()));
        map.put("imageUrl", createAttributeValue(model.getImageUrl()));

        return map;
    }

    private Map<String, AttributeValue> createAttributeMap(AWSDynamoDBModel model) {
        Map<String, AttributeValue> map = new HashMap();
        map.put("GameName", AttributeValue.fromS(model.getGameName()));
        map.put("Genre", AttributeValue.fromS(model.getGameGenre()));
        map.put("Platform", AttributeValue.fromS(model.getPlatform()));
        map.put("gameRating", AttributeValue.fromS(model.getGameRating().toString()));
        map.put("releaseDate", AttributeValue.fromS(model.getReleaseDate().toString()));
        map.put("isPreOrdered", AttributeValue.fromBool(model.getIsPreOrdered()));
        map.put("imageUrl", AttributeValue.fromS(model.getImageUrl()));
        map.put("userName", AttributeValue.fromS(model.getUserName()));

        return map;
    }

    private AttributeValueUpdate createAttributeValue(String value) {
        return AttributeValueUpdate.builder().value(AttributeValue.builder().s(value).build()).action("PUT").build();
    }

    private AttributeValueUpdate createAttributeValue(boolean value) {
        return AttributeValueUpdate.builder().value(AttributeValue.builder().bool(value).build()).action("PUT").build();
    }

    private AWSDynamoDBModel mapToAWSDynamoDBModel(Map<String, AttributeValue> map) {
        return new AWSDynamoDBModel(map.get("GameName").s(),
                map.get("Genre").s(),
                map.get("Platform").s(),
                map.get("userName").s(),
                LocalDate.parse(map.get("releaseDate").s()),
                Float.valueOf(map.get("gameRating").s()),
                map.get("imageUrl").s(),
                map.get("isPreOrdered").bool());
    }
}
