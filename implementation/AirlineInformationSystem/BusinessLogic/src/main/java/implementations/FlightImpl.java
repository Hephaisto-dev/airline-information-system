package implementations;

import interfaces.Airplane;
import interfaces.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FlightImpl implements Flight {

    private String flightID;
    private RouteImpl route;
    private LocalTime etdTime;
    private LocalDate etdDate;
    private LocalDateTime etdDateTime;
    private LocalTime etaTime;
    private LocalDate etaDate;
    private LocalDateTime etaDateTime;
    private AirplaneImpl airplane;
    private int flightDuration;

    public FlightImpl(String from, String to, LocalDate dateETD, LocalTime timeETD, LocalDate dateETA,
            LocalTime timeETA, AirplaneImpl plane){
        this.airplane = plane;
        this.route = new RouteImpl(from, to);
        this.etdDate = dateETD;
        this.etdTime = timeETD;
        this.etdDateTime = LocalDateTime.of(dateETD, timeETD);
        this.etaDate = dateETA;
        this.etaTime = timeETA;
        this.etaDateTime = LocalDateTime.of(dateETA, timeETA);
        this.flightID = "FL_" + from + "-" + to + "_" + dateETD.toString() + "_" + plane.getPlaneID();
        if(timeETA.compareTo(timeETD) >= 0){
            this.flightDuration = (timeETD.getHour() - timeETA.getHour())*60 + (timeETD.getMinute() - timeETA.getMinute()) + 24*60;
            //getting the time here and then adding the time of a whole day to it, to ensure that there's no negative value
        }else{
            this.flightDuration = (timeETD.getHour() - timeETA.getHour())*60 + (timeETD.getMinute() - timeETA.getMinute());
        }
    }

    public FlightImpl(RouteImpl Route, LocalDate dateETD, LocalTime timeETD, LocalDate dateETA,
                      LocalTime timeETA, AirplaneImpl plane){
        this.airplane = plane;
        this.route = Route;
        this.etdDate = dateETD;
        this.etdTime = timeETD;
        this.etdDateTime = LocalDateTime.of(dateETD, timeETD);
        this.etaDate = dateETA;
        this.etaTime = timeETA;
        this.etaDateTime = LocalDateTime.of(dateETA, timeETA);
        this.flightID = "FL_" + Route.getDeparturePlace() + "-" + Route.getArrivalPlace() + "_"
                + dateETD.toString() + "_" + plane.getPlaneID();
        if(timeETA.compareTo(timeETD) >= 0){
            this.flightDuration = (timeETD.getHour() - timeETA.getHour())*60 + (timeETD.getMinute() - timeETA.getMinute()) + 24*60;
            //getting the time here and then adding the time of a whole day to it, to ensure that there's no negative value
        }else{
            this.flightDuration = (timeETD.getHour() - timeETA.getHour())*60 + (timeETD.getMinute() - timeETA.getMinute());
        }
    }

    @Override
    public String getFlightID() {
        return this.flightID;
    }

    @Override
    public int getFlightDuration() {
        return this.flightDuration;
    }

    @Override
    public String departFrom() {
        return this.route.getDeparturePlace();
    }

    @Override
    public String ArriveIn() {
        return this.route.getArrivalPlace();
    }

    @Override
    public Airplane getPlane() {
        return this.airplane;
    }

    @Override
    public LocalDate getDayOfDeparture() {
        return this.etdDate;
    }

    @Override
    public LocalTime getTimeOfDeparture() {
        return this.etdTime;
    }

    @Override
    public LocalDateTime getETDLocalDateTime(){
        return this.etdDateTime;
    }

    @Override
    public LocalDate getDayOfArrival() {
        return this.etaDate;
    }

    @Override
    public LocalTime getTimeOfArrival() {
        return this.etaTime;
    }

    @Override
    public LocalDateTime getETALocalDateTime() {
        return this.etaDateTime;
    }
}
