package libraryapp.entities.games;

import libraryapp.entities.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "gameentity", schema = "libraryservice")
@Entity
public class GameEntityV2 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "gamename")
    private String gameName;

    @Column(name = "gamegenre")
    private String gameGenre;

    @Column(name = "gamerating")
    private Float gameRating;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "releasedate")
    private LocalDate releaseDate;

    @Column(name = "preordered")
    private Boolean isPreOrdered;

    @Column(name = "gameplatform")
    private String platform;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public Float getGameRating() {
        return gameRating;
    }

    public void setGameRating(Float gameRating) {
        this.gameRating = gameRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getPreOrdered() {
        return isPreOrdered;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
