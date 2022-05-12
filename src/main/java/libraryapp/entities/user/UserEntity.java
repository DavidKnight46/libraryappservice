package libraryapp.entities.user;

import libraryapp.entities.games.GameEntityV2;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "libraryservice")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<GameEntityV2> gameEntity;

    public long getId() {
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

    public List<GameEntityV2> getGameEntity() {
        return gameEntity;
    }

    public void setGameEntity(List<GameEntityV2> gameEntity) {
        this.gameEntity = gameEntity;
    }
}
