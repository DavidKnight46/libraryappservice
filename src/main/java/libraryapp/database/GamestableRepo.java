package libraryapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamestableRepo extends CrudRepository<GameEntity, Integer> {

    GameEntity findByGameName(String gameName);
}
