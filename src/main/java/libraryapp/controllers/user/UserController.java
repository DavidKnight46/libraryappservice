package libraryapp.controllers.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserController {

    @GetMapping(path = "/checkUser")
    @ResponseStatus(HttpStatus.OK)
    boolean checkUser(@RequestParam(name = "userName") String userName,
                      @RequestParam(name = "password") String password);
}
