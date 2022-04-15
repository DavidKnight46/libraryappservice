package libraryapp.service.games.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.entities.games.GameEntityV2;
import libraryapp.entities.user.UserEntity;
import libraryapp.models.response.GameResponse;
import libraryapp.repository.GameEntityRepository;
import libraryapp.repository.UserRepository;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.transformer.GameEntityV2Transformer;
import libraryapp.transformer.GameEntityV2TransformerImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImplV2 implements GameServices {

    private final GameEntityRepository gameEntityRepository;
    private final UserRepository userRepository;
    private final GameEntityV2Transformer gameEntityV2Transformer;

    public GameServiceImplV2(GameEntityRepository gameEntityRepository,
                             UserRepository userRepository) {
        this.gameEntityRepository = gameEntityRepository;
        this.userRepository = userRepository;
        this.gameEntityV2Transformer = new GameEntityV2TransformerImpl();
    }

    @Override
    public List<GameEntityV2Dto> getCollection(SortBy sortBy, Order order, int userId) {
        return this.gameEntityRepository.findAllByUser(userRepository.findById(userId).get())
                .get()
                .stream()
                .map(this::addGameEntityResponseList)
                .collect(Collectors.toList());
    }

    @Override
    public void addGame(GameEntityV2Dto gameModel) {
        UserEntity userEntity = userRepository.findById(gameModel.getUserId()).get();

        GameEntityV2 gameEntityV2 = new GameEntityV2();
        gameEntityV2.setId(gameModel.getId());
        gameEntityV2.setGameName(gameModel.getGameName());
        gameEntityV2.setGameGenre(gameModel.getGameGenre());
        gameEntityV2.setGameRating(gameModel.getGameRating());
        gameEntityV2.setPlatform(gameModel.getPlatform());
        gameEntityV2.setImageUrl(gameModel.getImageUrl());
        gameEntityV2.setPreOrdered(gameModel.getPreOrdered());
        gameEntityV2.setReleaseDate(gameModel.getReleaseDate());
        gameEntityV2.setUser(userEntity);

        gameEntityRepository.save(gameEntityV2);
    }

    @Override
    public void updateGame(GameEntityV2Dto gameModel){
        UserEntity userEntity = userRepository.findById(gameModel.getUserId()).get();

        GameEntityV2 gameEntityV2 = gameEntityV2Transformer.toEntity(gameModel);
        gameEntityV2.setUser(userEntity);

        gameEntityRepository.save(gameEntityV2);
    }

    @Override
    public List<GameEntityV2Dto> findGamesByDev_Name(String developerName) {
        return null;
    }

    @Override
    public List<GameEntityV2Dto> findGamesByPub_Name(String developerName) {
        return null;
    }

    private GameEntityV2Dto addGameEntityResponseList(GameEntityV2 gameEntityV2Dto) {
        return gameEntityV2Transformer.fromEntity(gameEntityV2Dto);
    }
}
