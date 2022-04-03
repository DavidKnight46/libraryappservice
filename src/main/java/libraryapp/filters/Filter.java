package libraryapp.filters;

import java.util.List;

public interface Filter<T> {
    T filterByGenre(List<T> items, String genreName);

}
