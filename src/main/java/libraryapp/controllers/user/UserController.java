package libraryapp.controllers.user;

import libraryapp.models.request.UserRequest;
import libraryapp.service.user.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usercontroller")
public class UserController {

    private final UserServiceI userService;

    public UserController(UserServiceI userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
     }

     @GetMapping(path = "/checkUser/{userName}/{password}")
     @ResponseStatus(HttpStatus.OK)
     @ResponseBody
     public boolean checkUser(@PathVariable(value = "userName") String userName,
                           @PathVariable(value = "password") String password){
        return userService.checkUser( userName, password );
     }
}
