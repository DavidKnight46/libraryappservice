package libraryapp.service;

import libraryapp.repository.UserRepository;
import libraryapp.transformer.UserTransformerImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTransformerImpl userTransformer;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userTransformer = new UserTransformerImpl();
    }

    public boolean checkUser(String userName, String password) {
        return userRepository.findUserEntityByUserNameAndPassword(userName, password).isPresent();

        //return userTransformer.fromUserEntity(userEntityByUserNameAndPassword.get());
    }
}
