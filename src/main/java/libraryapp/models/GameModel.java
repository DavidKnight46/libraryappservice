package libraryapp.models;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class GameModel {
    private String gameName;

    private int rating;

    private Date releaseDate;

    private DeveloperModelBuilder developer;

    private PublisherModel publisher;

    public DeveloperModelBuilder getDeveloper() {
        return developer;
    }

    public void setDeveloper(DeveloperModelBuilder developer) {
        this.developer = developer;
    }

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
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
