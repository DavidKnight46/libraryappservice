package libraryapp.models;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class AWSDynamoDBModel {

    private String name;
    private String genre;
    private String platform;
    private String userName;
    private LocalDate releaseDate;
    private Float gameRating;
    private List<String> imageUrls;
    private Boolean isPreOrdered;
}
