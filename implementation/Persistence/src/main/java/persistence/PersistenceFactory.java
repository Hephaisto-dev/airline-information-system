package persistence;

/**
 * Factory to provide PersistenceAPI implementation.
 *
 * @author Informatics Fontys Venlo
 */
public interface PersistenceFactory {

    static PersistenceAPI getImplementation() {
        return PersistenceAPIImpl.INSTANCE;
    }

}
