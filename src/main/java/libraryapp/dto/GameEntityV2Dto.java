package libraryapp.dto;

import libraryapp.models.response.DeveloperResponse;
import libraryapp.models.response.PublisherResponse;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class GameEntityV2Dto implements Serializable {
    private Long id;
    private String gameName;
    private String gameGenre;
    private Float gameRating;
    private String imageUrl;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private Boolean isPreOrdered;
    private String platform;
    private Integer userid;

    public GameEntityV2Dto(Long id, String gameName, String gameGenre, Float gameRating, String imageUrl, LocalDate releaseDate, Boolean isPreOrdered, DeveloperResponse developer, PublisherResponse publisher, String platform, Integer userid) {
        this.id = id;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.imageUrl = imageUrl;
        this.releaseDate = releaseDate;
        this.isPreOrdered = isPreOrdered;
        this.platform = platform;
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
