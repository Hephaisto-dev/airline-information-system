package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.impl.FlightImpl;
import datarecords.FlightData;
import persistence.api.NoDBConnectionException;

import java.time.LocalDateTime;

public interface FlightFactory {
    static Flight createFlight(Airport from, Airport to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                               Airplane airplaneData) throws NoDBConnectionException {
        if (true) {
            return new FlightImpl(from, to, etdDateTime, etaDateTime, airplaneData);
        } else {
            throw new NoDBConnectionException();
        }
    }

    static Flight createFlight(FlightData flightData) {
        return new FlightImpl(flightData);
    }
}
