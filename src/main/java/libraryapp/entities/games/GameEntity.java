package libraryapp.entities.games;

import libraryapp.entities.user.UserEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "game", schema = "libraryservice")
@NoArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String gameName;

    @Column
    private int rating;

    @Column
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private DeveloperEntity developer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private PublisherEntity publisher;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public DeveloperEntity getDeveloper() {
        return developer;
    }

    public void setDeveloper(DeveloperEntity developer) {
        this.developer = developer;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameEntity that = (GameEntity) o;

        if (id != that.id) return false;
        if (rating != that.rating) return false;
        if (gameName != null ? !gameName.equals(that.gameName) : that.gameName != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (developer != null ? !developer.equals(that.developer) : that.developer != null) return false;
        return publisher != null ? publisher.equals(that.publisher) : that.publisher == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gameName != null ? gameName.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        return result;
    }
}
