package businesslogic.implementation;

import businesslogic.api.manager.Manager;
import persistence.StorageService;

import java.util.HashSet;
import java.util.Set;

public class ManagerImpl<T extends Record> implements Manager<T> {
    private final Set<T> tSet = new HashSet<>();
    //TODO use the storageService when adding, deleting or getting all
    private final StorageService<T> storageService;

    public ManagerImpl(StorageService<T> storageService) {
        this.storageService = storageService;
    }

    @Override
    public T add(T t) {
        tSet.add(t);
        return t;
    }

    @Override
    public void delete(T t) {
        tSet.remove(t);
    }

    @Override
    public Set<T> getAll() {
        return tSet;
    }
}
