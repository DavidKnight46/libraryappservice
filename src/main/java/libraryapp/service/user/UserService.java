package libraryapp.service.user;

import libraryapp.models.UserModel;

public interface UserService {
    boolean checkUser(String userName, String password);

    void addUser(UserModel user);

    void deleteUser(String userId);
}
