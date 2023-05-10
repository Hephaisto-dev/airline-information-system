package businesslogic.impl;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.Manager;
import persistence.api.StorageService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ManagerImpl<T extends PersistantDataContainer<D>, D extends Record> implements Manager<T, D> {
    private final Map<String, T> storage = new HashMap<>();
    private final StorageService<D> storageService;

    public ManagerImpl(StorageService<D> storageService) {
        this.storageService = storageService;
        forceUpdate();
    }

    @Override
    public T add(T t) {
        if (storage.containsKey(t.getId()) || storageService.add(t.getData()) == null) {
            return null;
        }
        storage.put(t.getId(), t);
        return t;
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(storage.values());
    }

    @Override
    public T getById(String id) {
        return storage.get(id);
    }

    @Override
    public boolean remove(T t) {
        boolean remove = storage.remove(t.getId()) != null;
        if (remove) {
            remove = storageService.remove(t.getId());
        }
        return remove;
    }

    @Override
    public void forceUpdate() {
        storage.clear();
        storageService.getAll().stream()
                .map(this::createPersistantDataContainer)
                .forEach(persistantDataContainer -> storage.put(persistantDataContainer.getId(), persistantDataContainer));
    }

    protected abstract T createPersistantDataContainer(D data);
}