package libraryapp.controllers.user;

import libraryapp.dto.UserEntityDto;
import libraryapp.models.request.UserRequest;
import libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/adduser")
    public void addUser(@RequestBody UserRequest user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") String id) {
        userService.deleteUser(id);
    }
}
