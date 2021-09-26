package libraryapp.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "libraryservice.game")
@Data
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "")
    private String gameName;

    @Column(name = "")
    private int rating;

//    @Column(name = "")
//    private GamePublisher gamePublisher;

    @Column(name = "")
    private Date releaseDate;

    @Column(name = "")
    private int userId;

//    @Column(name = "")
//    private Developer developer;
}
