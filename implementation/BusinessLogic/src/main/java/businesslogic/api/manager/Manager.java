package businesslogic.api.manager;

import businesslogic.api.common.PersistantDataContainer;

import java.util.Set;

public interface Manager<T extends PersistantDataContainer<D>, D extends Record> {
    T add(T t);

    void delete(T t);

    /**
     * Get an undoable list of all the objects in the manager
     *
     * @return an unmodifiable list of all the objects in the manager
     */
    Set<T> getAll();

    T getById(String id);
}
