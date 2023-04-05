package datarecords;

import java.time.Duration;
import java.time.LocalDateTime;

public record FlightData(String id, RouteData routeData, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                         Duration flightDuration, AirplaneData airplane) {
    public FlightData(String id, RouteData routeData, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Duration flightDuration, AirplaneData airplane) {
        this.id = id;
        this.routeData = routeData;
        this.etdDateTime = etdDateTime;
        this.etaDateTime = etaDateTime;
        this.flightDuration = flightDuration;
        this.airplane = airplane;
    }

}
