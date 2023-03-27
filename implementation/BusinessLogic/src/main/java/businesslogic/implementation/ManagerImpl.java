package businesslogic.implementation;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.Manager;
import persistence.StorageService;

import java.util.HashSet;
import java.util.Set;

public class ManagerImpl<T extends PersistantDataContainer<D>, D extends Record> implements Manager<T, D> {
    private final Set<T> storage = new HashSet<>();
    //TODO use the storageService when adding, deleting or getting all
    private final StorageService<D> storageService;

    public ManagerImpl(StorageService<D> storageService) {
        this.storageService = storageService;
    }

    @Override
    public T add(T t) {
        storage.add(t);
        return t;
    }

    @Override
    public void delete(T t) {
        storage.remove(t);
    }

    @Override
    public Set<T> getAll() {
        return storage;
    }
}
