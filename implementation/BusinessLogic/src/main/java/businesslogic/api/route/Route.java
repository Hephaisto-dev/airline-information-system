package businesslogic.api.route;

import businesslogic.api.airport.Airport;
import businesslogic.api.common.PersistantDataContainer;
import datarecords.FlightData;
import datarecords.RouteData;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

public interface Route extends PersistantDataContainer<RouteData> {

    String getId();
    Airport getFrom();

    Airport getTo();

    RouteData getRouteData();

    Set<FlightData> getFlights();

    Map<FlightData, Duration> getFlightTransits();

    Duration getDuration();

}
