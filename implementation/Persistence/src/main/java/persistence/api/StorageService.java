package persistence.api;

import persistence.api.exceptions.PersistanceException;

import java.util.HashSet;
import java.util.Set;

public interface StorageService<D extends Record> {
    D add(D data) throws PersistanceException;

    default Set<D> getAll() {
        return new HashSet<>();
    }

    default boolean remove(String id) {
        return true;
    }
}
