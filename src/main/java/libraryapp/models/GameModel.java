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

    private DeveloperModelBuilder developerModel;

    private PublisherModel publisherModel;

    public DeveloperModelBuilder getDeveloperModel() {
        return developerModel;
    }

    public void setDeveloperModel(DeveloperModelBuilder developerModel) {
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
