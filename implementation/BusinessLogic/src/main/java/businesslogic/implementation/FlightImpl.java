package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightImpl extends RouteImpl implements Flight {

    private final FlightData flightData;
    private final Airplane airplane;
    private final LocalDateTime LDTd;
    private final LocalDateTime LDTa;


    public FlightImpl(Airport from, Airport to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Duration flightDuration,
                      Airplane airplane) throws IllegalArgumentException {
        super(from, to);
        if (etdDateTime.isAfter(etaDateTime)) {
            throw new IllegalArgumentException("ETD must be before ETA");
        }
        this.flightData = new FlightData("FL_" + from.getName() + "-" + to.getName() + "_" +
                etdDateTime + "_" + airplane.getId(), routeData, etdDateTime, etaDateTime, flightDuration,
                airplane.getData());
        this.airplane = airplane;
        this.LDTd = etdDateTime;
        this.LDTa = etaDateTime;
    }

    public FlightImpl(Airport from, Airport to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Airplane airplane) throws IllegalArgumentException {
        this(from, to, etdDateTime, etaDateTime,
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
        return this.LDTd;
    }

    @Override
    public LocalDateTime getETA() {return this.LDTa;}

    @Override
    public Route getRoute() {
        return this;
    }

    @Override
    public FlightData getData() {
        return flightData;
    }

    @Override
    public String toString() {
        return "FlightImpl{" +
                "flightData=" + flightData +
                ", airplane=" + airplane +
                '}';
    }
}
