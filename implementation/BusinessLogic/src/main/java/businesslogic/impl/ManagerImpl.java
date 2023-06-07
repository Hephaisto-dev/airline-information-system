package businesslogic.impl;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.Manager;
import persistence.api.StorageService;
import persistence.api.exceptions.PersistanceException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public abstract class ManagerImpl<T extends PersistantDataContainer<D>, D extends Record> implements Manager<T, D> {
    private final Map<String, T> storage = new HashMap<>();
    private final StorageService<D> storageService;

    public ManagerImpl(StorageService<D> storageService) {
        this.storageService = storageService;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        // Update the storage every minute
        scheduledExecutorService.scheduleAtFixedRate(this::forceUpdate, 0, 20, TimeUnit.SECONDS);
    }

    @Override
    public T add(T t) throws PersistanceException {
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
        return storageService.remove(t.getId()) && storage.remove(t.getId()) != null;
    }

    @Override
    public void forceUpdate() {
        storage.clear();
        Map<String, T> newStorage = storageService.getAll().stream()
                .map(this::createPersistantDataContainer)
                .collect(Collectors.toMap(PersistantDataContainer::getId, persistantDataContainer -> persistantDataContainer));
        storage.putAll(newStorage);
    }

    protected abstract T createPersistantDataContainer(D data);
}
