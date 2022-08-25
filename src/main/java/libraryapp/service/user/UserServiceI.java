package libraryapp.service.user;

import libraryapp.aws.dynamo.AWSDynamoDBClientUser;
import libraryapp.models.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceI implements UserService{

    private final AWSDynamoDBClientUser clientUser;

    public UserServiceI(AWSDynamoDBClientUser clientUser) {
        this.clientUser = clientUser;
    }

    @Override
    public boolean checkUser(String userName, String password) {
        return this.clientUser.checkUser(userName, password);
    }

    @Override
    public void addUser(UserRequest user) {
        this.clientUser.createUser(user.getUserName(), user.getPassword());
    }

    @Override
    public void deleteUser(String userId) {
        this.deleteUser(userId);
    }
}
