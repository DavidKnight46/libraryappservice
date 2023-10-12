package libraryapp.database;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "gamestable")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
