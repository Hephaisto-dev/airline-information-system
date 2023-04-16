package businesslogic.implementation;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.Manager;
import persistence.api.StorageService;

import java.util.*;

public abstract class ManagerImpl<T extends PersistantDataContainer<D>, D extends Record> implements Manager<T, D> {
    private final Set<T> storage = new HashSet<>();
    private final StorageService<D> storageService;

    public ManagerImpl(StorageService<D> storageService) {
        this.storageService = storageService;
        forceUpdate();
    }

    @Override
    public T add(T t) {
        if (storage.stream().anyMatch(data -> data.getId().equals(t.getId()))) {
            return null;
        }
        storage.add(t);
        storageService.add(t.getData());
        return t;
    }

    @Override
    public void delete(T t) {
        storage.remove(t);
    }

    @Override
    public Set<T> getAll() {
        return Collections.unmodifiableSet(storage);
    }

    @Override
    public T getById(String id) {
        return storage.stream().filter(data -> data.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean remove(T t) {
        boolean remove = storage.remove(t);
        if (remove) {
            remove = storageService.remove(t.getId());
        }
        return remove;
    }

    @Override
    public void forceUpdate() {
        storage.clear();
        storageService.getAll().forEach(data -> storage.add(createPersistantDataContainer(data)));
    }

    protected abstract T createPersistantDataContainer(D data);
}
