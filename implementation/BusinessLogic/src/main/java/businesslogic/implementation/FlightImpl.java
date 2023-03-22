package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;
import businesslogic.api.route.RouteFactory;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightImpl extends RouteImpl implements Flight {

    private final FlightData flightData;
    private final Airplane airplane;

    public FlightImpl(Route route, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Duration flightDuration,
                      Airplane airplane) throws IllegalArgumentException {
        super(route.getRouteData());
        if (etdDateTime.isAfter(etaDateTime)) {
            throw new IllegalArgumentException("ETD must be before ETA");
        }
        this.flightData = new FlightData("FL_" + routeData.from() + "-" + routeData.to() + "_" +
                etdDateTime + "_" + airplane.getId(), routeData, etdDateTime, etaDateTime, flightDuration,
                airplane.getAirplaneData());
        this.airplane = airplane;
    }

    public FlightImpl(Airport from, Airport to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Airplane airplane) throws IllegalArgumentException {
        this(RouteFactory.createRoute(from, to), etdDateTime, etaDateTime,
                Duration.between(etdDateTime, etaDateTime), airplane);
    }

    @Override
    public String getId() {
        return flightData.id();
    }

    @Override
    public Duration getFlightDuration() {
        return flightData.flightDuration();
    }

    @Override
    public Airplane getAirplane() {
        return airplane;
    }

    @Override
    public LocalDateTime getETD() {
        return null;
    }

    @Override
    public LocalDateTime getETA() {
        return null;
    }

    @Override
    public Route getRoute() {
        return this;
    }

    @Override
    public String toString() {
        return "FlightImpl{" +
                "flightData=" + flightData +
                ", airplane=" + airplane +
                '}';
    }
}
