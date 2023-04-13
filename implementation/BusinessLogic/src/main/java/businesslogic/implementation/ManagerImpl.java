package businesslogic.implementation;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.Manager;
import persistence.StorageService;

import java.util.*;

public class ManagerImpl<T extends PersistantDataContainer<D>, D extends Record> implements Manager<T, D> {
    private final Set<T> storage = new HashSet<>();
    private final StorageService<D> storageService;

    public ManagerImpl(StorageService<D> storageService) {
        this.storageService = storageService;
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
}
