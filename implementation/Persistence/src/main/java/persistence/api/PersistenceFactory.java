package persistence.api;

import persistence.impl.PersistenceAPIImpl;

/**
 * Factory to provide PersistenceAPI implementation.
 *
 * @author Informatics Fontys Venlo
 */
public interface PersistenceFactory {

    /**
     * Get PersistenceAPI implementation.
     *
     * @return a singleton instance of the PersistenceAPI implementation.
     */
    static PersistenceAPI getImplementation() {
        return PersistenceAPIImpl.INSTANCE;
    }

}
