package datarecords;

import java.time.Duration;
import java.time.LocalDateTime;

public record FlightData(String id, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                         Duration flightDuration, String airplaneId, String departureAirportId,
                         String arrivalAirportId) {
}
