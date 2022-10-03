package libraryapp.models.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class GameResponse {
    private String gameName;

    private int rating;

    private LocalDate releaseDate;

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
