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
    public CreateTableResponse createTable(String tableName) {
        return dynamoDbClient.createTable(CreateTableRequest.builder()
                .tableName(tableName)
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
        ScanResponse scanResponse = dynamoDbClient.scan(ScanRequest.builder()
                .tableName(userName)
                .attributesToGet("GameName", "Platform", "Genre").build());

        return scanResponse.items().stream().map(this::mapToAWSDynamoDBModel).collect(Collectors.toList());
    }

    private AWSDynamoDBModel mapToAWSDynamoDBModel(Map<String, AttributeValue> map){
        return new AWSDynamoDBModel(map.get("GameName").s(),
                map.get("Genre").s(),
                map.get("Platform").s(),
                "", LocalDate.now(), 1.0f, null, true);

    }

    @Override
    public void putItem(AWSDynamoDBModel model, String tableName) {
        boolean hasTable = dynamoDbClient.listTables().tableNames().contains(tableName);

        if(!hasTable){
            createTable(tableName);
        }

        Map<String, AttributeValue> map = new HashMap();
        map.put("GameName", AttributeValue.fromS(model.getName()));
        map.put("Genre", AttributeValue.fromS(model.getGenre()));
        map.put("Platform", AttributeValue.fromS(model.getPlatform()));

        try {
            dynamoDbClient.putItem(PutItemRequest.builder().tableName(tableName).item(map).build());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
