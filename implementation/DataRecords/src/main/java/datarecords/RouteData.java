package datarecords;

import java.time.Duration;
import java.util.Map;

public record RouteData(Map<FlightData, Duration> flightTransits, String id) {

    public RouteData(String id) {
        this(null, "RT_");
    }
}
