package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.Seat;
import businesslogic.api.airplane.SeatImpl;
import businesslogic.api.airport.Airport;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightStatus;
import businesslogic.api.route.Route;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightImpl extends RouteImpl implements Flight {

    private final FlightData flightData;
    private final Airplane airplane;
    private final LocalDateTime LDTd;
    private final LocalDateTime LDTa;
    private FlightStatus flightStatus = FlightStatus.SCHEDULED;

    private ArrayList<Seat> bookedSeats;


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
    public LocalDateTime getETA() {
        return this.LDTa;
    }

    @Override
    public Route getRoute() {
        return this;
    }

    @Override
    public String bookSeat(int column, String row) {
        if(column > airplane.getLength()){
            return "Column number exceeding the amount of columns on this plane";
        }
        if(row.length() != 1){
            return "Only one letter allowed as row identification";
        }
        char charAt = row.charAt(0);
        int c = Character.valueOf(charAt);
        if(c < Character.valueOf('A') || c > Character.valueOf('Z')){
            return "The row must be identified by a single capital letter of the English Alphabet (A-Z)";
        }
        c -= Character.valueOf('A');
        if(c > airplane.getWidth()-1){
            return "The row must be identified by a single capital letter of the English Alphabet (A-Z)";
        }
        Seat seat = new SeatImpl(charAt,column);
        boolean booked = false;
        for(Seat sit: bookedSeats){
            if(seat.getID().equals(sit.getID())){
                booked = true;
                break;
            }
        }
        if(!booked){
            bookedSeats.add(seat);
            return "Seat was successfully booked";
        }else{
            return "Seat is already booked by someone else";
        }
    }

    @Override
    public String cancelBookedSeat(String targetID) {
        int size = bookedSeats.size();
        for(int i = 0; i < size; i++){
            if(targetID.equals(bookedSeats.get(i).getID())){
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
}
