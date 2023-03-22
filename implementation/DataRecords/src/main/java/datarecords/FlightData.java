package datarecords;

import java.time.Duration;
import java.time.LocalDateTime;

public record FlightData(String id, RouteData routeData, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                         Duration flightDuration, AirplaneData airplane) {
}
