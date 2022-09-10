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
                                .build())
                .keySchema(KeySchemaElement.builder()
                        .keyType(KeyType.HASH)
                        .attributeName("GameName")
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder().readCapacityUnits(10L).writeCapacityUnits(10L).build())
                .build());
    }

    @Override
    public List<AWSDynamoDBModel> getItems(String userName) {
        Map<String, AttributeValue> map = new HashMap();
        map.put("userName", AttributeValue.fromS(userName));

        ScanResponse scanResponse = dynamoDbClient.scan(ScanRequest.builder()
                .tableName(userName)
                .filterExpression(String.format("userName = :%s", userName))
                .expressionAttributeValues(map)
                .build());

        return scanResponse.items().stream().map(this::mapToAWSDynamoDBModel).collect(Collectors.toList());
    }

    private AWSDynamoDBModel mapToAWSDynamoDBModel(Map<String, AttributeValue> map) {
        return new AWSDynamoDBModel(map.get("GameName").s(),
                map.get("Genre").s(),
                map.get("Platform").s(),
                "",
                LocalDate.parse(map.get("releaseDate").s()),
                Float.valueOf(map.get("gameRating").s()),
                map.get("imageUrl").s(),
                map.get("isPreOrdered").bool());

    }

    @Override
    public void putItem(AWSDynamoDBModel model) {
        boolean hasTable = dynamoDbClient.listTables().tableNames().contains(tableName);

        if (!hasTable) {
            createTable();
        }

        Map<String, AttributeValue> map = new HashMap();
        map.put("GameName", AttributeValue.fromS(model.getGameName()));
        map.put("Genre", AttributeValue.fromS(model.getGameGenre()));
        map.put("Platform", AttributeValue.fromS(model.getPlatform()));
        map.put("gameRating", AttributeValue.fromS(model.getGameRating().toString()));
        map.put("releaseDate", AttributeValue.fromS(model.getReleaseDate().toString()));
        map.put("isPreOrdered", AttributeValue.fromBool(model.getIsPreOrdered()));
        map.put("imageUrl", AttributeValue.fromS(model.getImageUrl()));
        map.put("userName", AttributeValue.fromS(model.getUserName()));

        try {
            dynamoDbClient.putItem(PutItemRequest.builder().tableName(this.tableName).item(map).build());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
