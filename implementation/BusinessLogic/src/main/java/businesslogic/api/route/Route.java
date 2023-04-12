package businesslogic.api.route;

import businesslogic.api.airport.Airport;
import businesslogic.api.flight.Flight;
import datarecords.RouteData;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

public interface Route {

    String getId();
    Airport getFrom();

    Airport getTo();

    RouteData getRouteData();

    Set<Flight> getFlights();

    Map<Flight, Duration> getFlightTransits();

    Duration getDuration();
}
