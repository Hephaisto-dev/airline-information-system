package businesslogic.implementation;

import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.route.Route;
import datarecords.FlightData;
import datarecords.RouteData;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

public class RouteImpl implements Route {
    protected final RouteData routeData;
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
        return AirportFactory.createAirport(flightData.departure());
    }

    @Override
    public Airport getTo() {
        return AirportFactory.createAirport(flightData.arrival());
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
    public Set<FlightData> getFlights() {
        return routeData.flightTransits().keySet();
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
