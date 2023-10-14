package libraryapp.database;

import javax.persistence.*;

@Entity
@Table(name = "gamestable")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "gamename")
    public String gameName;

    @Column
    public Integer rating;

    @Column(name = "releasedate")
    public String releaseDate;

    @Column(name = "imageurl")
    public String imageUrl;

    @Column(name = "ispreordered")
    public boolean isPreOrdered;

}
