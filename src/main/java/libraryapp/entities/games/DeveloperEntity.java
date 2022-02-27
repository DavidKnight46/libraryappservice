package libraryapp.entities.games;

import javax.persistence.*;

@Entity
@Table(name = "developer", schema = "libraryservice")
public class DeveloperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "dev_name")
    private String name;

    @OneToOne(mappedBy = "developer", fetch = FetchType.LAZY)
    private GameEntity gameEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameEntity getGameEntity() {
        return gameEntity;
    }

    public void setGameEntity(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }
}
