package libraryapp.service.user;

import libraryapp.repository.UserRepository;
import libraryapp.transformer.UserTransformerImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTransformerImpl userTransformer;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userTransformer = new UserTransformerImpl();
    }

    @Override
    public boolean checkUser(String userName, String password) {
        return userRepository.findUserEntityByUserNameAndPassword(userName, password).isPresent();
    }
}
