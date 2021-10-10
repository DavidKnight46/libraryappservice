package libraryapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "libraryservice.game")
@Data
@NoArgsConstructor
public class GameEntity {

    public GameEntity(String gameName, int rating, Date releaseDate, int userId, DeveloperEntity developer, PublisherEntity publisher) {
        this.gameName = gameName;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.userId = userId;
        this.developer = developer;
        this.publisher = publisher;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "")
    private String gameName;

    @Column(name = "")
    private int rating;

    @Column(name = "")
    private Date releaseDate;

    @Column(name = "")
    private int userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private DeveloperEntity developer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private PublisherEntity publisher;
}
