package libraryapp.service.user;

import libraryapp.dto.UserEntityDto;
import libraryapp.entities.user.UserEntity;
import libraryapp.models.request.UserRequest;
import libraryapp.repository.UserRepository;
import libraryapp.transformer.UserTransformerImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTransformerImpl userTransformer;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userTransformer = new UserTransformerImpl();
    }

    @Override
    public UserEntityDto checkUser(String userName, String password) {
        AtomicReference<UserEntityDto> userEntityDto = new AtomicReference();

        userRepository.findUserEntityByUserNameAndPassword(userName, password).ifPresentOrElse((value) -> {
            UserEntity userEntity = userRepository.findUserEntityByUserNameAndPassword(userName, password).get();

            userEntityDto.set(new UserEntityDto(userEntity.getId(), userEntity.getUserName(), userEntity.getPassword()));
        }, () -> {
            throw new IllegalArgumentException();
        });

        return userEntityDto.get();
    }

    @Override
    public void addUser(UserRequest user) {
        userRepository.save(userTransformer.toUserEntity(user));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(Integer.parseInt(userId));
    }
}
