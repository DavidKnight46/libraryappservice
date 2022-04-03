package libraryapp.controllers.user;

import libraryapp.models.request.UserRequest;
import libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean checkUser(String userName, String password) {
        return userService.checkUser(userName, password);
    }

    @Override
    public void addUser(UserRequest user) {
        userService.addUser(user);
    }

    @Override
    public void deleteUser(String userId) {
        userService.deleteUser(userId);
    }
}
