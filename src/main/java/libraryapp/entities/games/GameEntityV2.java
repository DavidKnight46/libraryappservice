package libraryapp.entities.games;

import libraryapp.entities.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "gameentity")
@Entity
public class GameEntityV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_genre")
    private String gameGenre;

    @Column(name = "game_rating")
    private Float gameRating;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "pre_ordered")
    private Boolean isPreOrdered;

    @Column(name = "gameplatform")
    private String platform;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
