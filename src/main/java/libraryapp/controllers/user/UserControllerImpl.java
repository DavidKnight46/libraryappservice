package libraryapp.controllers.user;

import libraryapp.dto.UserEntityDto;
import libraryapp.models.request.UserRequest;
import libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserControllerImpl {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/getuser")
    public UserEntityDto checkUser(@RequestParam(name = "username") String userName,
                                   @RequestParam(name = "password") String password) {
        return userService.checkUser(userName, password);
    }

    public void addUser(UserRequest user) {
        userService.addUser(user);
    }

    public void deleteUser(String userId) {
        userService.deleteUser(userId);
    }
}
