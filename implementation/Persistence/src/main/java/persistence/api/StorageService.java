package persistence.api;

import java.util.HashSet;
import java.util.Set;

public interface StorageService<D extends Record> {
    D add(D data);


    default Set<D> getAll() {
        return new HashSet<>();
    }

    default boolean remove(String id) {
        return true;
    }
}
