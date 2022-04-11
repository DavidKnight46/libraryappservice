package libraryapp.service.games.game;

import libraryapp.dto.GameEntityV2Dto;
import libraryapp.entities.games.GameEntityV2;
import libraryapp.models.request.GameModelRequest;
import libraryapp.models.response.GameResponse;
import libraryapp.repository.DeveloperRepository;
import libraryapp.repository.GameEntityRepository;
import libraryapp.repository.UserRepository;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.transformer.GameEntityV2Transformer;
import libraryapp.transformer.GameEntityV2TransformerImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImplV2 implements GameServices<GameEntityV2Dto> {

    private final GameEntityRepository gameEntityRepository;
    private final UserRepository userRepository;
    private final GameEntityV2Transformer gameEntityV2Transformer;
    private int userId;

    public GameServiceImplV2(GameEntityRepository gameEntityRepository,
                             UserRepository userRepository,
                             DeveloperRepository developerRepository) {
        this.gameEntityRepository = gameEntityRepository;
        this.userRepository = userRepository;
        this.gameEntityV2Transformer = new GameEntityV2TransformerImpl();
    }

    @Override
    public List<GameEntityV2Dto> getCollection(SortBy sortBy, Order order, int userId) {
        this.userId = userId;
        return this.gameEntityRepository.findAllById(Collections.singleton(userId))
                .stream()
                .map(this::addGameEntityResponseList)
                .collect(Collectors.toList());
    }

    @Override
    public GameResponse getItem(int id) {
        return null;
    }

    @Override
    public List<GameEntityV2Dto> findGamesByDev_Name(String developerName) {
        return null;
    }

    @Override
    public List<GameEntityV2Dto> findGamesByPub_Name(String developerName) {
        return null;
    }

    @Override
    public void addGame(GameEntityV2Dto gameModel) {
        gameModel.getId();

        GameEntityV2 gameEntityV2 = gameEntityV2Transformer.toEntity(gameModel);

        gameEntityRepository.save(gameEntityV2);
    }

    private GameEntityV2Dto addGameEntityResponseList(GameEntityV2 gameEntityV2Dto) {
        return gameEntityV2Transformer.fromEntity(gameEntityV2Dto);
    }
}
