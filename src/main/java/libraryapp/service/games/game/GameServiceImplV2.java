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
    public void addGame(GameEntityV2Dto gameModel, String userName) {
        AWSDynamoDBModelAdapter awsDynamoDBModelAdapter = new AWSDynamoDBModelAdapter();

        AWSDynamoDBModel awsDynamoDBModel = awsDynamoDBModelAdapter.convertTo(gameModel);

        this.dyanmoDbClient.putItem(awsDynamoDBModel, userName);
    }

    @Override
    public boolean createUserGameTable(String tableName) {
        if(this.dyanmoDbClient.createTable(tableName).sdkHttpResponse().isSuccessful()) {
            return true;
        } else {
            return false;
        }
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
