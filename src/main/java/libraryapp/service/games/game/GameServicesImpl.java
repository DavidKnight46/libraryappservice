package libraryapp.service.games.game;

import libraryapp.entities.games.GameEntity;
import libraryapp.models.GameModel;
import libraryapp.models.PublisherModel;
import libraryapp.repository.GameRepository;
import libraryapp.service.Order;
import libraryapp.service.SortBy;
import libraryapp.transformer.DeveloperTransformerImpl;
import libraryapp.transformer.GameTransformerImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameServicesImpl implements GameServices<GameModel> {

    private final GameRepository gameRepository;
    private final GameTransformerImpl gameTransformer;
    private final DeveloperTransformerImpl developerTransformer;

    private Set<GameModel> setOfGames;

    public GameServicesImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.gameTransformer = new GameTransformerImpl();
        this.developerTransformer = new DeveloperTransformerImpl();
    }

    @Override
    public Set<GameModel> getCollection(SortBy sortBy, Order order) {

        switch (sortBy){
            case NAME: System.out.println("");
                break;
            case RATING: sortByRating();
                break;
            case RELEASE_DATE: System.out.println("world");
                break;
            default:
                break;
        }

        if(order == Order.DESC){
            List<GameEntity> collect = gameRepository.findAll().stream().sorted(new GameComparator()).collect(Collectors.toList());

            Collections.reverse(collect);

            return collect
                    .stream()
                    .map(this::mapToGame)
                    .collect(Collectors.toSet());
        } else {
            return setOfGames;
        }
    }

    @Override
    public GameModel getItem(int id) {
       return gameTransformer.getGameFromEntity(gameRepository.findById(id).orElseThrow());
    }

    @Override
    public List<GameModel> findGamesByDev_Name(String developerName) {
        Optional<List<GameEntity>> byDeveloper = gameRepository.findByDeveloper_Name(developerName);

        return byDeveloper
                .orElseThrow()
                .stream()
                .map(this::toGame)
                .collect(Collectors.toList());
    }

    @Override
    public List<GameModel> findGamesByPub_Name(String publisherName) {
        Optional<List<GameEntity>> byPublisher_name = gameRepository.findByPublisher_Name(publisherName);

        return byPublisher_name
                .orElseThrow()
                .stream()
                .map(this::toGame)
                .collect(Collectors.toList());
    }

    private GameModel toGame(GameEntity gameEntity){
        return gameTransformer.getGameFromEntity(gameEntity);
    }

    private GameModel mapToGame(GameEntity gameEntity) {
        GameModel gameModel = gameTransformer.getGameFromEntity(gameEntity);

        gameModel.setDeveloper(developerTransformer.toDeveloperModel(gameEntity.getDeveloper()));
        gameModel.setPublisher(new PublisherModel(gameEntity.getPublisher().getName()));

        return gameModel;
    }

    private void sortByRating(){
        setOfGames = gameRepository
                .findAll()
                .stream()
                .sorted(new GameComparator())
                .map(this::mapToGame)
                .collect(Collectors.toSet());
    }

}
