package libraryapp.entities.games;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "developerTable")
@NoArgsConstructor
public class DeveloperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToOne(mappedBy = "developer")
    private GameEntity gameEntity;
}
