package businesslogic.api.manager;

import persistence.StorageService;

import java.util.Set;

public interface Manager<T, V extends StorageService<T>> {
    T add(T t);

    void delete(T t);

    Set<T> getAll();
}
