package businesslogic.api.flight;

import businesslogic.api.manager.AirplaneManager;
import businesslogic.impl.FlightImpl;
import datarecords.FlightData;
import persistence.api.AirplaneStorageService;

public interface FlightFactory {
    static Flight createFlight(FlightData flightData) {
        return new FlightImpl(flightData);
    }
}
