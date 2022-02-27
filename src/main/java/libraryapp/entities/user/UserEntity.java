package libraryapp.entities.user;

import libraryapp.entities.games.GameEntity;

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

    @Column(name = "userPassword")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<GameEntity> gameEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GameEntity> getGameEntity() {
        return gameEntity;
    }

    public void setGameEntity(List<GameEntity> gameEntity) {
        this.gameEntity = gameEntity;
    }
}
