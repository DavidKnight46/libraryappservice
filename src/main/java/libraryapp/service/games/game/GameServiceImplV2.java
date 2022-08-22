package libraryapp.service.games.game;

import libraryapp.aws.dynamo.AWSDynamoDBClientGame;
import libraryapp.dto.GameEntityV2Dto;
import libraryapp.models.AWSDynamoDBModel;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImplV2 implements GameServices {
    private final AWSDynamoDBClientGame dyanmoDbClient;

    public GameServiceImplV2(AWSDynamoDBClientGame createClient) {
        this.dyanmoDbClient = createClient;
    }

    @Override
    public List<AWSDynamoDBModel> getCollection(SortBy sortBy, Order order, String userName) {
        return dyanmoDbClient.getItems(userName);
    }

    @Override
    public void editItem(AWSDynamoDBModel item) {
//        GameEntityV2 gameEntityV2 = gameEntityV2Transformer.toEntity(item);
//
//        gameEntityV2.setUser(userRepository.findById(Math.toIntExact(item.getUserid())).get());
//
//        gameEntityRepository.save(gameEntityV2);
    }

    @Override
    public void deleteItem(AWSDynamoDBModel item) {

    }

    @Override
    public void addGame(GameEntityV2Dto gameModel, int id) {

    }

    @Override
    public List<GameEntityV2Dto> findGamesByDev_Name(String developerName) {
        return null;
    }

    @Override
    public List<GameEntityV2Dto> findGamesByPub_Name(String developerName) {
        return null;
    }

}
