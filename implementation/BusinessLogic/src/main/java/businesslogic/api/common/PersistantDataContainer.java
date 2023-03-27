package businesslogic.api.common;

public interface PersistantDataContainer<D extends Record> {
    D getData();
}
