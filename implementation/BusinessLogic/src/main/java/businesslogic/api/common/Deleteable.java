package businesslogic.api.common;

public interface Deleteable {
    /**
     * Delete the object
     *
     * @return true if the object was successfully deleted, false otherwise
     */
    boolean delete();
}
