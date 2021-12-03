package libraryapp.repository;

import libraryapp.entities.games.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Integer> {

    Optional<List<GameEntity>> findByDeveloper_Name(String developerName);

    Optional<List<GameEntity>> findByPublisher_Name(String publisherName);

    Optional<List<GameEntity>> findByUserId(Integer integer);
}
