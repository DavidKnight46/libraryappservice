package libraryapp.models;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class AWSDynamoDBModel {

    private String gameName;
    private String gameGenre;
    private String platform;
    private String userName;
    private LocalDate releaseDate;
    private Float gameRating;
    private List<String> imageUrls;
    private Boolean isPreOrdered;
}
