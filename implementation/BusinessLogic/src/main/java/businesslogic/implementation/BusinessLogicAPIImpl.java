package businesslogic.implementation;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.customer.CustomerManager;
import persistence.PersistenceAPI;

/**
 * Actual business logic implementation.
 *
 * @author Informatics Fontys Venlo
 */
public record BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) implements BusinessLogicAPI {

    @Override
    public CustomerManager getCustomerManager() {
        return new CustomerManager(persistenceAPI.getCustomerStorageService());
    }
}
