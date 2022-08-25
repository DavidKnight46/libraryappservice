package libraryapp.service;

import java.util.List;

public interface CollectionService<T> {
    List<T> getCollection(String userName);

    void editItem(T item);

    void deleteItem(T item);
}
