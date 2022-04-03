package libraryapp.repository;

import libraryapp.entities.games.GameEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameEntityRepository extends JpaRepository<GameEntityV2, Integer> {

}
