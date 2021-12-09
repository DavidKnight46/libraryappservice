package libraryapp.controllers.user;

import libraryapp.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping(path = "/checkUser")
    @ResponseStatus(HttpStatus.OK)
    boolean checkUser(@RequestParam(name = "userName") String userName,
                      @RequestParam(name = "password") String password);

    @PostMapping(path = "/addUser")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void addUser(@RequestBody UserModel user);

    @DeleteMapping(path = "/deleteUser/{userId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteUser(@PathVariable(name = "userId") String userId);
}
