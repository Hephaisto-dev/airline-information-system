package businesslogic.implementation;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.*;
import persistence.PersistenceAPI;

import java.util.List;

/**
 * Actual business logic implementation.
 *
 * @author Informatics Fontys Venlo
 */
public class BusinessLogicAPIImpl implements BusinessLogicAPI {
    private final List<Manager<? extends PersistantDataContainer<? extends Record>, ? extends Record>> managers;

    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        managers = List.of(
                new CustomerManager(persistenceAPI.getCustomerStorageService()),
                new AirplaneManager(persistenceAPI.getAirplaneStorageService()),
                new AirportManager(persistenceAPI.getAirportStorageService()),
                new FlightManager(persistenceAPI.getFlightStorageService())
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
        return managers.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .findFirst()
                .orElseThrow();
    }
}
