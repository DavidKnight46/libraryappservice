package libraryapp.repository;

import libraryapp.entities.games.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperEntity, Integer> {

    Optional<DeveloperEntity> findByName(String name);
}
