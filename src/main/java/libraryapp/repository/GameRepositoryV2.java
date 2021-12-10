package libraryapp.repository;

import libraryapp.entities.gamesv2.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepositoryV2 extends JpaRepository<GameEntity, Integer> {
}
