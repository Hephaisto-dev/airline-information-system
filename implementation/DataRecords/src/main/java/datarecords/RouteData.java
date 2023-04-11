package datarecords;

import java.time.Duration;
import java.util.Map;

public record RouteData(AirportData from, AirportData to, Map<FlightData, Duration> flightTransits) {
}
