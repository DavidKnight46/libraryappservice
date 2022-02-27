package libraryapp.models.response;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class GameResponse {
    private String gameName;

    private int rating;

    private LocalDate releaseDate;

    private DeveloperResponse developer;

    private PublisherResponse publisher;

    public DeveloperResponse getDeveloper() {
        return developer;
    }

    public void setDeveloper(DeveloperResponse developer) {
        this.developer = developer;
    }

    public PublisherResponse getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherResponse publisher) {
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
