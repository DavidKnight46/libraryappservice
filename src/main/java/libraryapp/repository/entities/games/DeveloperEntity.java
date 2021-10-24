package libraryapp.repository.entities.games;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
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
