package libraryapp.repository.entities.games;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "publisher")
    private GameEntity gameEntity;

}
