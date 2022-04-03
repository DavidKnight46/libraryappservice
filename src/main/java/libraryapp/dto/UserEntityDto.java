package libraryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

//@AllArgsConstructor
public class UserEntityDto implements Serializable {
    private final int id;
    private final String userName;
    private final String password;

    public UserEntityDto(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
