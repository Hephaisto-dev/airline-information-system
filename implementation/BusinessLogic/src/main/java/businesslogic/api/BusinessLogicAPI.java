package businesslogic.api;

import businesslogic.api.manager.AirplaneManager;
import businesslogic.api.manager.AirportManager;
import businesslogic.api.manager.CustomerManager;
import businesslogic.api.manager.FlightManager;

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
}
