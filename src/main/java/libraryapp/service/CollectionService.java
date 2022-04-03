package libraryapp.service;

import libraryapp.dto.GameEntityV2Dto;

import java.util.List;

public interface CollectionService<T> {
    List<GameEntityV2Dto> getCollection(SortBy sortBy, Order order, int userId);

    T getItem(int id);
}
