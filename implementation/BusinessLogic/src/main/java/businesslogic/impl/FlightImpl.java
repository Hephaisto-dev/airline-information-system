package businesslogic.impl;

import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.Seat;
import businesslogic.api.airplane.SeatImpl;
import businesslogic.api.airport.Airport;
import businesslogic.api.customer.Price;
import businesslogic.api.customer.PriceImpl;
import businesslogic.api.flight.Flight;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightImpl implements Flight {

    private final FlightData flightData;
    private final Price ticketCost = new PriceImpl(1000);

    private final List<Seat> bookedSeats = new ArrayList<>();

    public FlightImpl(FlightData flightData) {
        this.flightData = flightData;
    }


    @Override
    public Price getPrice() {
        return this.ticketCost;
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
        return BusinessLogicFactory.getImplementation().getAirplaneManager().getById(flightData.airplaneId());
    }

    @Override
    public LocalDateTime getETD() {
        return flightData.etdDateTime();
    }

    @Override
    public LocalDateTime getETA() {
        return flightData.etaDateTime();
    }

    @Override
    public String bookSeat(int column, char row) {
        if (column > getAirplane().getLength()) {
            return "Row number exceeding the amount of rows on this plane";
        }
        if (row < 'A' || row > 'Z') {
            return "The column must be identified by a single capital letter of the English Alphabet (A-Z)";
        }
        int r = row - 'A';
        if (r >= getAirplane().getWidth()) {
            return "The column exceeds the amount of columns on this plane";
        }
        Seat seat = new SeatImpl(row, column);
        //if (bookedSeats.stream().noneMatch(seat1 -> seat1.getId().equals(seat.getId()))) { THIS IS COMMENTED BECAUSE THE ALGORITHM FOR SEATS IS NOT IMPLEMENTED
        bookedSeats.add(seat);
        return "Seat was successfully booked";
//        } else {
//            return "Seat is already booked by someone else";
//        }
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
        return flightData.id();
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

    @Override
    public Airport getArrival() {
        return BusinessLogicFactory.getImplementation().getAirportManager().getById(flightData.arrivalAirportId());
    }

    @Override
    public Airport getDeparture() {
        return BusinessLogicFactory.getImplementation().getAirportManager().getById(flightData.departureAirportId());
    }

    @Override
    public boolean delete() {
        return BusinessLogicFactory.getImplementation().getFlightManager().remove(this);
    }

}
