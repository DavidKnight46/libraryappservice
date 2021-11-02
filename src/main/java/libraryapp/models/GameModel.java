package libraryapp.models;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
public class GameModel {
    private String gameName;

    private int rating;

    private Date releaseDate;

    private DeveloperModel developerModel;

    private PublisherModel publisherModel;

    public DeveloperModel getDeveloperModel() {
        return developerModel;
    }

    public void setDeveloperModel(DeveloperModel developerModel) {
        this.developerModel = developerModel;
    }

    public PublisherModel getPublisherModel() {
        return publisherModel;
    }

    public void setPublisherModel(PublisherModel publisherModel) {
        this.publisherModel = publisherModel;
    }

    public String getGameName() {
        return gameName;
    }

    public int getRating() {
        return rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
