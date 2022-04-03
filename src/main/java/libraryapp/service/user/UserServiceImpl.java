package libraryapp.service.user;

import libraryapp.entities.user.UserEntity;
import libraryapp.models.request.UserRequest;
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

    @Override
    public void addUser(UserRequest user) {
        UserEntity userEntity = userTransformer.toUserEntity(user);

        userRepository.save(userTransformer.toUserEntity(user));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(Integer.parseInt(userId));
    }
}
