package businesslogic.api.manager;

import businesslogic.api.common.PersistantDataContainer;

import java.util.Set;

public interface Manager<T extends PersistantDataContainer<D>, D extends Record> {
    T add(T t);

    void delete(T t);

    Set<T> getAll();

    T getById(String id);

    boolean remove(T t);

    void forceUpdate();
}
