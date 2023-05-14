package datarecords;

import java.time.Duration;
import java.util.Map;

public record RouteData(String id, Map<String, Duration> flightIdsTransits) {
}
