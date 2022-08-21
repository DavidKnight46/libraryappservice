package libraryapp.service.games.game;

import com.amazonaws.services.rds.AmazonRDS;
import libraryapp.dto.GameEntityV2Dto;
import libraryapp.entities.games.GameEntityV2;
import libraryapp.repository.GameEntityRepository;
import libraryapp.repository.UserRepository;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.transformer.GameEntityV2Transformer;
import libraryapp.transformer.GameEntityV2TransformerImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImplV2 implements GameServices {

    private final GameEntityRepository gameEntityRepository;
    private final UserRepository userRepository;
    private final GameEntityV2Transformer gameEntityV2Transformer;
    private final AmazonRDS awsRdsClient;

    public GameServiceImplV2(GameEntityRepository gameEntityRepository,
                             UserRepository userRepository,
                             AmazonRDS awsRdsClient) {
        this.gameEntityRepository = gameEntityRepository;
        this.userRepository = userRepository;
        this.awsRdsClient = awsRdsClient;
        this.gameEntityV2Transformer = new GameEntityV2TransformerImpl();
    }

    @Override
    public List<GameEntityV2Dto> getCollection(SortBy sortBy, Order order, int userId) {
        //awsRdsClient.describeDBInstances().getDBInstances().get(0).getDBName();

        return this.gameEntityRepository.findAllByUser(userRepository.findById(userId).get())
                .get()
                .stream()
                .map(this::addGameEntityResponseList)
                .collect(Collectors.toList());
    }

    @Override
    public void editItem(GameEntityV2Dto item) {
        GameEntityV2 gameEntityV2 = gameEntityV2Transformer.toEntity(item);

        gameEntityV2.setUser(userRepository.findById(Math.toIntExact(item.getUserid())).get());

        gameEntityRepository.save(gameEntityV2);
    }

    @Override
    @Transactional
    public void deleteItem(GameEntityV2Dto gameEntityV2Dto) {
        GameEntityV2 gameEntityV2 = gameEntityV2Transformer.toEntity(gameEntityV2Dto);



        gameEntityRepository.deleteById(23L);
    }

    @Override
    public void addGame(GameEntityV2Dto gameModel, int id) {
        GameEntityV2 gameEntityV2 = new GameEntityV2();
        gameEntityV2.setGameName(gameModel.getGameName());
        gameEntityV2.setGameGenre(gameModel.getGameGenre());
        gameEntityV2.setGameRating(gameModel.getGameRating());
        gameEntityV2.setPlatform(gameModel.getPlatform());
        gameEntityV2.setImageUrl(gameModel.getImageUrl());
        gameEntityV2.setPreOrdered(gameModel.getPreOrdered());
        gameEntityV2.setReleaseDate(gameModel.getReleaseDate());
        gameEntityV2.setUser(userRepository.findById(id).get());

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
