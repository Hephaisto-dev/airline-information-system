package businesslogic.api.common;

public interface PersistantDataContainer<D extends Record> extends StringIdentifiable {
    D getData();
}
