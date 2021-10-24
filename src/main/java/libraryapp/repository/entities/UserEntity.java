package libraryapp.repository.entities;

import libraryapp.repository.entities.games.GameEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<GameEntity> gameEntity;
}
