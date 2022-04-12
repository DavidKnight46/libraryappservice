package libraryapp.repository;

import libraryapp.entities.games.GameEntityV2;
import libraryapp.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameEntityRepository extends JpaRepository<GameEntityV2, Integer> {

    Optional<List<GameEntityV2>> findAllByUser(UserEntity user);
}
