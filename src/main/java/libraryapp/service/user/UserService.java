package libraryapp.service.user;

import libraryapp.models.request.UserRequest;

public interface UserService {
    boolean checkUser(String userName, String password);

    void addUser(UserRequest user);

    void deleteUser(String userId);
}
