package libraryapp.models;

import lombok.Value;

import java.time.LocalDate;

@Value
public class AWSDynamoDBModel {

    private String gameName;
    private String gameGenre;
    private String platform;
    private String userName;
    private LocalDate releaseDate;
    private Float gameRating;
    private String imageUrl;
    private Boolean isPreOrdered;
}
