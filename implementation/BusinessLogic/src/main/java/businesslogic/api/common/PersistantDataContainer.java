package businesslogic.api.common;

public interface PersistantDataContainer<T extends Record> {
    T getData();
}
