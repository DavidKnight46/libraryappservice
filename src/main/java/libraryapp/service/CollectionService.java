package libraryapp.service;

import java.util.List;
import java.util.Set;

public interface CollectionService<T> {

    List<T> getCollection(SortBy sortBy, Order order);

    T getItem(int id);

}
