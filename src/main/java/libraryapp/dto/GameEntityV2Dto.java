package libraryapp.dto;

import libraryapp.models.response.DeveloperResponse;
import libraryapp.models.response.PublisherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

//@Data
public class GameEntityV2Dto implements Serializable {
    private final Integer id;
    private final String gameName;
    private final String gameGenre;
    private final Float gameRating;
    private final String imageUrl;
    private final LocalDate releaseDate;
    private final Boolean isPreOrdered;
    private final UserEntityDto user;
    private final DeveloperResponse developer;
    private final PublisherResponse publisher;

    public GameEntityV2Dto(Integer id, String gameName, String gameGenre, Float gameRating, String imageUrl, LocalDate releaseDate, Boolean isPreOrdered, UserEntityDto user, DeveloperResponse developer, PublisherResponse publisher) {
        this.id = id;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.imageUrl = imageUrl;
        this.releaseDate = releaseDate;
        this.isPreOrdered = isPreOrdered;
        this.user = user;
        this.developer = developer;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public Float getGameRating() {
        return gameRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Boolean getPreOrdered() {
        return isPreOrdered;
    }

    public UserEntityDto getUser() {
        return user;
    }

    public DeveloperResponse getDeveloper() {
        return developer;
    }

    public PublisherResponse getPublisher() {
        return publisher;
    }
}
