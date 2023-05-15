package businesslogic.impl;

import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.airport.Airport;
import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;
import datarecords.RouteData;

import java.time.Duration;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        return this.getFlights().stream()
                .min(Comparator.comparing(Flight::getETD))
                .map(Flight::getDeparture)
                .orElse(null);
    }

    @Override
    public Airport getTo() {
        return this.getFlights().stream()
                .max(Comparator.comparing(Flight::getETA))
                .map(Flight::getArrival)
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
        return BusinessLogicFactory.getImplementation().getFlightManager().getAll().stream()
                .filter(flight -> routeData.flightIdsTransits().containsKey(flight.getId()))
                .collect(Collectors.toSet());
    }

    @Override
    public Map<Flight, Duration> getFlightTransits() {
        return routeData.flightIdsTransits().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> BusinessLogicFactory.getImplementation().getFlightManager().getById(entry.getKey()),
                        Map.Entry::getValue
                ));
    }

    @Override
    public Duration getDuration() {
        return routeData.flightIdsTransits().values().stream().reduce(Duration.ZERO, Duration::plus);
    }

    @Override
    public RouteData getData() {
        return routeData;
    }
}
