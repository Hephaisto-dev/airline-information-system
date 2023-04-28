package businesslogic.impl;

import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;
import datarecords.FlightData;
import datarecords.RouteData;

import java.time.Duration;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class RouteImpl implements Route {
    private final RouteData routeData;

    public RouteImpl(RouteData routeData) {
        this.routeData = routeData;
    }

    @Override
    public String getId() {
        return routeData.id();
    }

    @Override
    public Airport getFrom() {
        return this.routeData.flightTransits().keySet().stream()
                .min(Comparator.comparing(FlightData::etdDateTime))
                .map(flight -> AirportFactory.createAirport(flight.departure()))
                .orElse(null);
    }

    @Override
    public Airport getTo() {
        return this.routeData.flightTransits().keySet().stream()
                .max(Comparator.comparing(FlightData::etaDateTime))
                .map(flight -> AirportFactory.createAirport(flight.arrival()))
                .orElse(null);
    }

    @Override
    public String toString() {
        return getFrom() + " -> " + getTo();
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
