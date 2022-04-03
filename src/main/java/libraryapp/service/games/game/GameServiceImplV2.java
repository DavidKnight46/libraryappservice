package libraryapp.service.games.game;

import libraryapp.entities.games.GameEntityV2;
import libraryapp.dto.GameEntityV2Dto;
import libraryapp.entities.user.UserEntity;
import libraryapp.dto.UserEntityDto;
import libraryapp.models.request.GameModelRequest;
import libraryapp.models.response.GameResponse;
import libraryapp.repository.GameEntityRepository;
import libraryapp.repository.UserRepository;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImplV2 implements GameServices<GameResponse>{

    private final GameEntityRepository gameEntityRepository;
    private final UserRepository userRepository;

    private List<GameEntityV2Dto> list;
    private List<GameResponse> list2;

    public GameServiceImplV2(GameEntityRepository gameEntityRepository,
                             UserRepository userRepository) {
        this.gameEntityRepository = gameEntityRepository;
        this.userRepository = userRepository;
        this.list = new ArrayList();
        this.list2 =  new ArrayList();
    }

    @Override
    public List<GameResponse> getCollection(SortBy sortBy, Order order, int userId) {
        List<GameEntityV2> allById = this.gameEntityRepository.findAllById(Collections.singleton(userId));

        allById.forEach(this::foo);

        list.stream().forEach(this::foo2);

        return list2;
    }

    private void foo2(GameEntityV2Dto gameEntityV2Dto){
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameName(gameEntityV2Dto.getGameName());
        gameResponse.setRating(Math.getExponent(gameEntityV2Dto.getGameRating()));
        //gameResponse

        list2.add(gameResponse);
    }

    private void foo(GameEntityV2 gameEntityV2Dto){
        Optional<UserEntity> byId = userRepository.findById(1);

        list.add( new GameEntityV2Dto(gameEntityV2Dto.getId(),
                gameEntityV2Dto.getGameName(),
                gameEntityV2Dto.getGameGenre(),
                gameEntityV2Dto.getGameRating(),
                gameEntityV2Dto.getImageUrl(),
                LocalDate.now(),
                gameEntityV2Dto.getPreOrdered(),
                new UserEntityDto(byId.get().getId(),
                        byId.get().getUserName(),
                        byId.get().getPassword()),
                null,
                null));
    }

    @Override
    public GameResponse getItem(int id) {
        return null;
    }

    @Override
    public List<GameResponse> findGamesByDev_Name(String developerName) {
        return null;
    }

    @Override
    public List<GameResponse> findGamesByPub_Name(String developerName) {
        return null;
    }

    @Override
    public void addGame(GameModelRequest gameModel) {

    }
}
