package businesslogic.api.route;

import businesslogic.api.airport.Airport;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.flight.Flight;
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

    Set<Flight> getFlights();

    Map<FlightData, Duration> getFlightTransits();

    Duration getDuration();

}
