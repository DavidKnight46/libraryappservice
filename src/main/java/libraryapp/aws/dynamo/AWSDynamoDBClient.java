package libraryapp.aws.dynamo;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AWSDynamoDBClient implements AWSDynamoDBClientI {

    private final String tableName;
    private final DynamoDbClient dynamoDbClient;

    public AWSDynamoDBClient(String tableName, DynamoDbClient createClient) {
        this.tableName = tableName;
        this.dynamoDbClient = createClient;
    }

    @Override
    public CreateTableResponse createTable() {
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
    public List<AWSDynamoDBModel> getItems(String userName) {
        Map<String, Condition> map = new HashMap<>();
        map.put("UserName", Condition.builder()
                .comparisonOperator(ComparisonOperator.EQ)
                .attributeValueList(AttributeValue.builder().s(userName).build())
                .build());

        QueryRequest queryRequest = QueryRequest.builder()
                .keyConditions(map)
                .tableName(this.tableName)
                .attributesToGet("Genre", "Platform", "GameName")
                .build();

        QueryResponse query = dynamoDbClient.query(queryRequest);

        ArrayList<AWSDynamoDBModel> awsDynamoDBModelArrayList = new ArrayList();

        for (Map<String, AttributeValue> e : query.items()) {
            awsDynamoDBModelArrayList.add(new AWSDynamoDBModel(e.get("GameName").s(),
                    e.get("Genre").s(),
                    e.get("Platform").s(),
                    userName));
        }

        return awsDynamoDBModelArrayList;
    }

    @Override
    public void putItem(AWSDynamoDBModel model) {
        Map<String, AttributeValue> map = new HashMap();
        map.put("UserName", AttributeValue.fromS(model.getUserName()));
        map.put("Genre", AttributeValue.fromS(model.getGenre()));
        map.put("GameName", AttributeValue.fromS(model.getName()));
        map.put("Platform", AttributeValue.fromS(model.getPlatform()));

        try {
            dynamoDbClient.putItem(PutItemRequest.builder().tableName(this.tableName).item(map).build());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
