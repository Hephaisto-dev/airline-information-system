package businesslogic.api.common;

public interface PersistantDataContainer<D extends Record> extends StringIdentifiable {
    /**
     * Get the data object
     *
     * @return the data object
     */
    D getData();

}
