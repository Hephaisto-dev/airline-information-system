package datarecords;

import java.util.Map;

public record RouteData(String name, String id, Map<String,Long> flightIdsAndTransits, int price) {
}
