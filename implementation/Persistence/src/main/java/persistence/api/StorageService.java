package persistence;

import java.util.ArrayList;
import java.util.List;

public interface StorageService<D extends Record> {
    D add(D data);


    default List<D> getAll() {
        return new ArrayList<>();
    }

    default boolean remove(String id) {
        return true;
    }
}
