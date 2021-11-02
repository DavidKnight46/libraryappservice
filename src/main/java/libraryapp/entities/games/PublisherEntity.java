package libraryapp.entities.games;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "publisher", schema = "libraryservice")
@NoArgsConstructor
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToOne(mappedBy = "publisher")
    private GameEntity gameEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
