package businesslogic.impl;

import businesslogic.api.airport.Airport;
import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;
import datarecords.FlightData;
import datarecords.RouteData;

import java.time.Duration;
import java.util.*;

public class RouteImpl implements Route {
    private final RouteData routeData;
    protected FlightData flightData;

    public RouteImpl(RouteData routeData) {
        this.routeData = routeData;
    }

    @Override
    public String getId() {
        return routeData.id();
    }

    @Override
    public Airport getFrom() {
        Map<FlightData, Duration> flightTranzits = getFlightTransits();
        for (FlightData flightData : flightTranzits.keySet()) {
            // Return the first key
            return getFrom();
        }
        return null;
    }

    @Override
    public Airport getTo() {
        Map<FlightData, Duration> flightTranzits = getFlightTransits();
        List<FlightData> keys = new ArrayList<>(flightTranzits.keySet());
        ListIterator<FlightData> iterator = keys.listIterator(keys.size());
        while (iterator.hasPrevious()) {
            // Return the last key
            return getTo();
        }
        return null;
    }

    @Override
    public String toString() {
        return flightData.departure() + " -> " + flightData.arrival();
    }

    @Override
    public RouteData getRouteData() {
        return routeData;
    }

    @Override
    public Set<Flight> getFlights() {
        return getFlights();
    }

    @Override
    public Map<FlightData, Duration> getFlightTransits() {
        return routeData.flightTransits();
    }

    @Override
    public Duration getDuration() {
        return routeData.flightTransits().entrySet().stream()
                .map(flightDurationEntry -> flightDurationEntry.getKey().flightDuration().plus(flightDurationEntry.getValue()))
                .reduce(Duration.ZERO, Duration::plus);
    }

    @Override
    public RouteData getData() {
        return routeData;
    }
}
