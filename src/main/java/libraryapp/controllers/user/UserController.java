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

     @PostMapping(path = "/checkUser")
     @ResponseStatus(HttpStatus.OK)
     @ResponseBody
     public boolean checkUser(@RequestBody UserRequest userRequest){
        return userService.checkUser(userRequest.getUserName(), userRequest.getPassword() );
     }
}
