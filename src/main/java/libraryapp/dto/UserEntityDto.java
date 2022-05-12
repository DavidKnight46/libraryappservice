package libraryapp.dto;

import java.io.Serializable;

public class UserEntityDto implements Serializable {
    private final long id;
    private final String userName;
    private final String password;

    public UserEntityDto(long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
