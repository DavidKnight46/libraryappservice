package libraryapp.aws.dynamo;

import lombok.Value;

@Value
public class AWSDynamoDBModel {

    private String name;
    private String genre;
    private String platform;
}
