package libraryapp.dto;

import libraryapp.models.response.DeveloperResponse;
import libraryapp.models.response.PublisherResponse;

import java.io.Serializable;
import java.time.LocalDate;

public class GameEntityV2Dto implements Serializable {
    private Integer id;
    private String gameName;
    private String gameGenre;
    private Float gameRating;
    private String imageUrl;
    private LocalDate releaseDate;
    private Boolean isPreOrdered;
    private String platform;

    public GameEntityV2Dto(Integer id, String gameName, String gameGenre, Float gameRating, String imageUrl, LocalDate releaseDate, Boolean isPreOrdered, UserEntityDto user, DeveloperResponse developer, PublisherResponse publisher, String platform) {
        this.id = id;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.imageUrl = imageUrl;
        this.releaseDate = releaseDate;
        this.isPreOrdered = isPreOrdered;
        this.platform = platform;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public void setGameRating(Float gameRating) {
        this.gameRating = gameRating;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPreOrdered(Boolean preOrdered) {
        isPreOrdered = preOrdered;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
