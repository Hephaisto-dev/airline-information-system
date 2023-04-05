package businesslogic.implementation;

import businesslogic.api.airport.Airport;
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
        this.flightTransits = new HashMap<>();
        this.routeData = new RouteData(from.getData(), to.getData(), new HashMap<>());
    }

    @Override
    public Airport getFrom() {
        return this.flightTransits.keySet().stream()
                .min((f1, f2) -> f1.getETD().compareTo(f2.getETD()))
                .map(flight -> flight.getRoute().getFrom())
                .orElse(null);
    }

    @Override
    public Airport getTo() {
        return this.flightTransits.keySet().stream()
                .max((f1, f2) -> f1.getETA().compareTo(f2.getETA()))
                .map(flight -> flight.getRoute().getTo())
                .orElse(null);
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
                .map(flightDurationEntry ->  flightDurationEntry.getKey().getFlightDuration().plus(flightDurationEntry.getValue()))
                .reduce(Duration.ZERO, Duration::plus);
    }
}
