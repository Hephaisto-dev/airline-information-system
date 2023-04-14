package businesslogic.implementation;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.*;
import persistence.api.PersistenceAPI;

import java.util.Map;

/**
 * Actual business logic implementation.
 *
 * @author Informatics Fontys Venlo
 */
public class BusinessLogicAPIImpl implements BusinessLogicAPI {
    /**
     * Map of all managers.
     * The key is the class of the manager.
     * The value is the manager itself.
     * Warning: Class type must me be the same of the manager.
     */
    private final Map<Class<? extends Manager<? extends PersistantDataContainer<? extends Record>, ? extends Record>>,
            ? extends Manager<? extends PersistantDataContainer<? extends Record>, ? extends Record>> managerRegistry;

    public BusinessLogicAPIImpl(PersistenceAPI persistenceAPI) {
        managerRegistry = Map.of(
                CustomerManager.class, new CustomerManager(persistenceAPI.getCustomerStorageService()),
                AirplaneManager.class, new AirplaneManager(persistenceAPI.getAirplaneStorageService()),
                AirportManager.class, new AirportManager(persistenceAPI.getAirportStorageService()),
                FlightManager.class, new FlightManager(persistenceAPI.getFlightStorageService()),
                BookingManager.class, new BookingManager(persistenceAPI.getBookingStorageService()),
                EmployeeManager.class, new EmployeeManager(persistenceAPI.getEmployeeStorageService())
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

    @Override
    public BookingManager getBookingManager() {
        return getManager(BookingManager.class);
    }


    @Override
    public EmployeeManager getEmployeeManager() {
        return getManager(EmployeeManager.class);
    }

    @Override
    public <U extends Manager<? extends PersistantDataContainer<D>, D>, D extends Record> U getManager(Class<U> clazz) {
        return clazz.cast(managerRegistry.get(clazz));
    }
}
