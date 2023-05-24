package datarecords;

import java.time.Duration;
import java.time.LocalDateTime;

// TODO ask if flightDuration shoyld be stored in the database
public record FlightData(String id, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                         Duration flightDuration, String airplaneId, String departureAirportId,
                         String arrivalAirportId) {
}
