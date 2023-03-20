package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.implementation.FlightImpl;

import java.time.LocalDateTime;

public interface FlightFactory {
    static Flight createFlight(String from, String to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                               Airplane airplane)
            throws IllegalArgumentException {
        return new FlightImpl(from, to, etdDateTime, etaDateTime, airplane);
    }
}
