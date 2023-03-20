package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.flight.Flight;
import datarecords.AirportData;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightImpl extends RouteImpl implements Flight {

    private final String flightID;
    private final LocalDateTime etdDateTime;
    private final LocalDateTime etaDateTime;
    private final Duration flightDuration;
    private final Airplane airplane;

    public FlightImpl(String from, String to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Duration flightDuration,
                      Airplane airplane) throws IllegalArgumentException {
        super(from, to);
        if (etdDateTime.isAfter(etaDateTime)) {
            throw new IllegalArgumentException("ETD must be before ETA");
        }
        this.etdDateTime = etdDateTime;
        this.etaDateTime = etaDateTime;
        this.flightDuration = flightDuration;
        this.airplane = airplane;
        this.flightID = "FL_" + from + "-" + to + "_" + etdDateTime + "_" + airplane.getId();
    }

    public FlightImpl(String from, String to, LocalDateTime etdDateTime, LocalDateTime etaDateTime, Airplane airplane)
            throws IllegalArgumentException {
        this(from, to, etdDateTime, etaDateTime,
                Duration.between(etdDateTime, etaDateTime), airplane);
    }

    @Override
    public String getId() {
        return this.flightID;
    }

    @Override
    public Duration getFlightDuration() {
        return this.flightDuration;
    }

    @Override
    public Airplane getAirplane() {
        return this.airplane;
    }

    @Override
    public LocalDateTime getETD() {
        return this.etdDateTime;
    }

    @Override
    public LocalDateTime getETA() {
        return this.etaDateTime;
    }

    @Override
    public AirportData getDepartureAirport() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public AirportData getArrivalAirport() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String toString() {
        return "FlightImpl{" +
                "flightID='" + flightID + '\'' +
                ", etdDateTime=" + etdDateTime +
                ", etaDateTime=" + etaDateTime +
                ", flightDuration=" + flightDuration +
                ", airplane=" + airplane +
                '}';
    }
}
