package businesslogic.implementation;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.*;
import persistence.PersistenceAPI;

import java.util.Map;

/**
 * Actual business logic implementation.
 *
 * @author Informatics Fontys Venlo
 */
public class BusinessLogicAPIImpl implements BusinessLogicAPI {
    private final Map<Class<? extends Manager<? extends PersistantDataContainer<? extends Record>, ? extends Record>>,
            Manager<? extends PersistantDataContainer<? extends Record>, ? extends Record>> managers;

    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        managers = Map.of(
                CustomerManager.class, new CustomerManager(persistenceAPI.getCustomerStorageService()),
                AirplaneManager.class, new AirplaneManager(persistenceAPI.getAirplaneStorageService()),
                AirportManager.class, new AirportManager(persistenceAPI.getAirportStorageService()),
                FlightManager.class, new FlightManager(persistenceAPI.getFlightStorageService())
        );
    }

    @Override
    public AirplaneManager getAirplaneManager() {
        return getManager(AirplaneManager.class);
    }

    @Override
    public AirportManager getAirportManager() {
        return getManager(AirportManager.class);
    }

    @Override
    public CustomerManager getCustomerManager() {
        return getManager(CustomerManager.class);
    }

    @Override
    public FlightManager getFlightManager() {
        return getManager(FlightManager.class);
    }

    private <D extends Record, U extends Manager<? extends PersistantDataContainer<D>, D>> U getManager(Class<U> clazz) {
        return clazz.cast(managers.get(clazz));
    }
}
