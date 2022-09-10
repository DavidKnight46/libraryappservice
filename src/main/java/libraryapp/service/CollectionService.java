package libraryapp.service;

import libraryapp.dto.GameEntityV2Dto;

import java.util.List;

public interface CollectionService<T> {

    List<T> getCollection(String userName);

    void editItem(T item);

    void deleteItem(T item);
}
