package businesslogic.implementation;

import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;
import datarecords.RouteData;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RouteImpl implements Route {
    protected final RouteData routeData;
    private final Map<Flight, Duration> flightTransits;

    public RouteImpl(Airport from, Airport to) {
        this(new HashMap<>(), new RouteData(from.getData(), to.getData(), new HashMap<>(), "RT_"));

    }

    public RouteImpl(Map<Flight, Duration> flightTransits, RouteData routeData) {
        this.routeData = routeData;
        this.flightTransits = flightTransits;
    }

    @Override
    public String getId() {
        return routeData.id();
    }

    @Override
    public Airport getFrom() {
        return AirportFactory.createAirport(routeData.from());
    }

    @Override
    public Airport getTo() {
        return AirportFactory.createAirport(routeData.to());
    }

    @Override
    public String toString() {
        return routeData.from().name() + " -> " + routeData.to().name();
    }

    @Override
    public RouteData getRouteData() {
        return routeData;
    }

    @Override
    public Set<Flight> getFlights() {
        return flightTransits.keySet();
    }

    @Override
    public Map<Flight, Duration> getFlightTransits() {
        return flightTransits;
    }

    @Override
    public Duration getDuration() {
        return flightTransits.entrySet().stream()
                .map(flightDurationEntry -> flightDurationEntry.getKey().getFlightDuration().plus(flightDurationEntry.getValue()))
                .reduce(Duration.ZERO, Duration::plus);
    }
}
