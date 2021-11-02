package libraryapp.entities.games;

import javax.persistence.*;

@Entity
@Table(name = "developer", schema = "libraryservice")
public class DeveloperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToOne(mappedBy = "developer")
    private GameEntity gameEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}