package businesslogic.implementation;

import businesslogic.api.manager.Manager;
import persistence.StorageService;

import java.util.HashSet;
import java.util.Set;

public class ManagerImpl<T, U extends StorageService<T>> implements Manager<T, U> {
    private final Set<T> tSet = new HashSet<>();
    private final StorageService<T> storageService;

    public ManagerImpl(U storageService) {
        this.storageService = storageService;
        tSet.addAll(storageService.getAll());
    }

    @Override
    public T add(T t) {
        tSet.add(t);
        storageService.add(t);
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
