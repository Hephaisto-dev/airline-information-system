package businesslogic.api;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.manager.*;

/**
 * API of the BusinessLogic layer.
 *
 * @author Informatics Fontys Venlo
 */
public interface BusinessLogicAPI {

    AirplaneManager getAirplaneManager();

    AirportManager getAirportManager();

    CustomerManager getCustomerManager();

    FlightManager getFlightManager();
    BookingManager getBookingManager();

    EmployeeManager getEmployeeManager();

    <U extends Manager<? extends PersistantDataContainer<D>, D>, D extends Record> U getManager(Class<U> clazz);
}
