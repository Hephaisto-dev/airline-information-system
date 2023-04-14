package businesslogic.api;

import businesslogic.implementation.BusinessLogicAPIImpl;
import persistence.api.PersistenceAPI;

/**
 * Factory to provide BusinessLogicAPI implementation.
 *
 * @author Informatics Fontys Venlo
 */
public interface BusinessLogicFactory {

    static BusinessLogicAPI getImplementation(PersistenceAPI persistenceAPI) {
        return new BusinessLogicAPIImpl(persistenceAPI);
    }
}
