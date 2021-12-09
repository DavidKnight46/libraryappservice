package libraryapp.models;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class GameModel {
    private String gameName;

    private int rating;

    private LocalDate releaseDate;

    private DeveloperModel developer;

    private PublisherModel publisher;

    public DeveloperModel getDeveloper() {
        return developer;
    }

    public void setDeveloper(DeveloperModel developer) {
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
