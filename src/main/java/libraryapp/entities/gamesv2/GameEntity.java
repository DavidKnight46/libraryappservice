package libraryapp.entities.gamesv2;

import libraryapp.entities.user.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "", schema = "")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "gamename")
    private String gameName;

    @Column
    private boolean isPreOrdered;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "", referencedColumnName = "")
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public boolean isPreOrdered() {
        return isPreOrdered;
    }

    public void setPreOrdered(boolean preOrdered) {
        isPreOrdered = preOrdered;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
