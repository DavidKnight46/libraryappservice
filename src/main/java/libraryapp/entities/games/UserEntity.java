package libraryapp.entities.games;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "libraryservice")
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
