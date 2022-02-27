package libraryapp.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    @JsonProperty
    private String userName;

    @JsonProperty
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return userPassword;
    }
}
