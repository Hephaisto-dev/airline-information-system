package datarecords;

import java.time.Duration;
import java.time.LocalDateTime;

public record FlightData(String id, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                         Duration flightDuration, AirplaneData airplane, AirportData departure, AirportData arrival) {
    public FlightData(String id, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Duration flightDuration, AirplaneData airplane, AirportData departure, AirportData arrival) {
        this.id = id;
        this.etdDateTime = etdDateTime;
        this.etaDateTime = etaDateTime;
        this.flightDuration = flightDuration;
        this.airplane = airplane;
        this.departure = departure;
        this.arrival = arrival;
    }
}
