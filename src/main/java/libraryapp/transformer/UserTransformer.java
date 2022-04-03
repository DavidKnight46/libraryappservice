package libraryapp.transformer;

import libraryapp.entities.user.UserEntity;
import libraryapp.models.request.UserRequest;
import libraryapp.models.response.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserTransformer {

    @Mappings({@Mapping(source = "userEntity.userName", target = "userName"),
               @Mapping(source = "userEntity.password", target = "password")})
    UserModel fromUserEntity(UserEntity userEntity);

    UserEntity toUserEntity(UserRequest userModel);
}
