package libraryapp.service;

import java.util.Set;

public interface CollectionService<T> {

    Set<T> getCollection(SortBy sortBy, Order order);

    T getItem(int id);

}
