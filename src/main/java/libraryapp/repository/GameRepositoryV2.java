package libraryapp.repository;

import libraryapp.entities.gamesv2.GameEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepositoryV2 extends JpaRepository<GameEntityV2, Integer> {
}
