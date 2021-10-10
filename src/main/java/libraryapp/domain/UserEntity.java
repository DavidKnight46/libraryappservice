package libraryapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libraryservice.users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "")
    private String userName;

    @Column(name = "")
    private String password;

    @OneToMany(mappedBy = "userId")
    private List<GameEntity> gameEntity;
}
