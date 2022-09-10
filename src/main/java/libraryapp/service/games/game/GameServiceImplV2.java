package libraryapp.service.games.game;

import libraryapp.aws.dynamo.AWSDynamoDBClientGame;
import libraryapp.dto.GameEntityV2Dto;
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

    }

    @Override
    public void deleteItem(AWSDynamoDBModel item) {

    }

    @Override
    public void addGame(GameEntityV2Dto gameModel) {
        AWSDynamoDBModelAdapter awsDynamoDBModelAdapter = new AWSDynamoDBModelAdapter();

        this.dyanmoDbClient.putItem(awsDynamoDBModelAdapter.convertTo(gameModel));
    }

    @Override
    public boolean editGame(GameEntityV2Dto gameModel) {
        return false;
    }

    @Override
    public boolean deleteGame() {
        return false;
    }
}
