package libraryapp.service;

import java.util.List;

public interface CollectionService<T> {
    List<T> getCollection(SortBy sortBy, Order order, int userId);

    T getItem(int id);
}
