package persistence.api;

import java.util.HashSet;
import java.util.Set;
import persistence.api.exceptions.PersistanceException;

public interface StorageService<D extends Record> {
    D add(D data) throws PersistanceException;


    default Set<D> getAll() {
        return new HashSet<>();
    }

    default boolean remove(String id) {
        return true;
    }
}
