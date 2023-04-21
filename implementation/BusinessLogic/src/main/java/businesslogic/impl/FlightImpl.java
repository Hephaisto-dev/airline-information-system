package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airplane.Seat;
import businesslogic.api.airplane.SeatImpl;
import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.customer.Price;
import businesslogic.api.customer.PriceImpl;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightStatus;
import businesslogic.api.route.Route;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightImpl extends RouteImpl implements Flight {

    private final FlightData flightData;
    private final Airplane airplane;
    private final LocalDateTime LDTd;
    private final LocalDateTime LDTa;
    private final List<Seat> bookedSeats;
    private final Price standardPrice;
    private FlightStatus flightStatus = FlightStatus.SCHEDULED;

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
        getFlightTransits().put(this, Duration.ZERO);
        this.bookedSeats = new ArrayList<>();
        this.standardPrice = new PriceImpl(2000);
    }

    public FlightImpl(Airport from, Airport to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Duration flightDuration,
                      Airplane airplane, Price price) throws IllegalArgumentException {
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
        getFlightTransits().put(this, Duration.ZERO);
        this.bookedSeats = new ArrayList<>();
        this.standardPrice = price;
    }

    public FlightImpl(Airport from, Airport to, LocalDateTime etdDateTime, LocalDateTime etaDateTime,
                      Airplane airplane) throws IllegalArgumentException {
        this(from, to, etdDateTime, etaDateTime,
                Duration.between(etdDateTime, etaDateTime), airplane);
    }

    public FlightImpl(FlightData flightData) {
        //TODO link to the managers to retrieve airplanes.
        this(AirportFactory.createAirport(flightData.routeData().from()),
                AirportFactory.createAirport(flightData.routeData().to()),
                flightData.etdDateTime(), flightData.etaDateTime(), flightData.flightDuration(),
                AirplaneFactory.createAirplane(flightData.airplane()));
    }

    @Override
    public Price getPrice() {
        return this.standardPrice;
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
    public LocalDateTime getETA() {
        return this.LDTa;
    }

    @Override
    public Route getRoute() {
        return this;
    }

    @Override
    public String bookSeat(int column, char row) {
        if (column > airplane.getLength()) {
            return "Row number exceeding the amount of rows on this plane";
        }
        if (row < 'A' || row > 'Z') {
            return "The column must be identified by a single capital letter of the English Alphabet (A-Z)";
        }
        int r = row - 'A';
        if (r >= airplane.getWidth()) {
            return "The column exceeds the amount of columns on this plane";
        }
        Seat seat = new SeatImpl(row, column);
        if (bookedSeats.stream().noneMatch(seat1 -> seat1.getId().equals(seat.getId()))) {
            bookedSeats.add(seat);
            return "Seat was successfully booked";
        } else {
            return "Seat is already booked by someone else";
        }
    }

    @Override
    public String cancelBookedSeat(String targetID) {
        int size = bookedSeats.size();
        for (int i = 0; i < size; i++) {
            if (targetID.equals(bookedSeats.get(i).getId())) {
                bookedSeats.remove(i);
                return "Seat successfully freed for booking once more";
            }
        }
        return "Seat " + targetID + " couldn't be found in the list of booked seats";
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

    @Override
    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    @Override
    public void changeStatus(FlightStatus newStatus) {
        flightStatus = newStatus;
    }

    @Override
    public Seat getSeat(String Seat_Id) {
        for (Seat sitter : bookedSeats) {
            if (sitter.getId().equals(Seat_Id)) {
                return sitter;
            }
        }
        return null;
    }
}
