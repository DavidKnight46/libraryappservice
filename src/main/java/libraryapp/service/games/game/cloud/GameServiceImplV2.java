package libraryapp.service.games.game.cloud;

import libraryapp.aws.dynamo.AWSDynamoDBClientGame;
import libraryapp.models.AWSDynamoDBModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImplV2 implements GameServices {
    private final AWSDynamoDBClientGame dyanmoDbClient;

    public GameServiceImplV2(AWSDynamoDBClientGame createClient) {
        this.dyanmoDbClient = createClient;
    }

    @Override
    public List<AWSDynamoDBModel> getCollection(String userName) {
        return dyanmoDbClient.getItems(userName);
    }

    @Override
    public void editItem(AWSDynamoDBModel item) {
        dyanmoDbClient.updateItem(item);
    }

    @Override
    public void deleteGame(String userName, String gameName) {
        dyanmoDbClient.deleteItem(userName, gameName);
    }

    @Override
    public void addItem(AWSDynamoDBModel gameModel) {
        this.dyanmoDbClient.putItem(gameModel);
    }
}
