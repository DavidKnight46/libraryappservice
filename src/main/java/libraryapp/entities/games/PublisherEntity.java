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

    @Column(name = "pub_name")
    private String name;

    @OneToOne(mappedBy = "publisher", fetch = FetchType.LAZY)
    private GameEntity gameEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
