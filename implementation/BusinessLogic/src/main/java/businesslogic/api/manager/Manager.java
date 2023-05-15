package businesslogic.api.manager;

import businesslogic.api.common.PersistantDataContainer;

import java.util.Collection;

public interface Manager<T extends PersistantDataContainer<D>, D extends Record> {
    /**
     * Add a new {@link PersistantDataContainer} to the manager
     * @param t the {@link PersistantDataContainer} to add
     * @return the added {@link PersistantDataContainer} or null if the {@link PersistantDataContainer} already exists
     */
    T add(T t);

    /**
     * Retrpieve all the {@link PersistantDataContainer} stored in the manager
     *
     * @return an unmodifiable {@link Collection} of all the {@link PersistantDataContainer} in the manager
     */
    Collection<T> getAll();

    /**
     * Get a {@link PersistantDataContainer} in the cache with the given id
     *
     * @param id the id of the {@link PersistantDataContainer}
     * @return the {@link PersistantDataContainer} with the given id
     */
    T getById(String id);

    boolean remove(T t);

    void forceUpdate();
}
