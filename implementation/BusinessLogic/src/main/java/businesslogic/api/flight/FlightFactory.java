package businesslogic.api.flight;

import businesslogic.impl.FlightImpl;
import datarecords.FlightData;

public interface FlightFactory {
    static Flight createFlight(FlightData flightData) {
        return new FlightImpl(flightData);
    }
}
