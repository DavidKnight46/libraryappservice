package libraryapp.service;

import java.util.List;

public interface CollectionService<T> {
    List<T> getCollection(SortBy sortBy, Order order, String userName);

    void editItem(T item);

    void deleteItem(T item);
}
