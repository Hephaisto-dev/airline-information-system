package businesslogic.api.customer;

import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;
import businesslogic.implementation.RouteImpl;

public class TicketImpl implements Ticket{

    private String person;
    private Flight flight;
    private String ticketID;
    private String seat;
    private String route;

    public TicketImpl(String who, Flight flyingFromTo, String sittingPlace){
        this.person = who;
        this.flight = flyingFromTo;
        this.seat = sittingPlace;
        this.ticketID = createID();
        this.route = flight.getData().routeData().from().id() + "-" + flight.getData().routeData().to().id();
    }

    @Override
    public String getTicketID() {
        return this.ticketID;
    }

    @Override
    public String getTicketOwner() {
        return this.person;
    }

    @Override
    public Flight getFlight() {
        return this.flight;
    }

    @Override
    public String getSeat() {
        return this.seat;
    }

    @Override
    public String getRouteDescription() {
        return this.route;
    }

    private String createID() {
        StringBuilder stringl = new StringBuilder();
        stringl.append("Ti_")
                .append(flight.getAirplane().getId())
                .append(":")
                .append(flight.getRoute().getFrom().getId())
                .append("-")
                .append(flight.getRoute().getTo().getId())
                .append("_")
                .append(flight.getETD().getDayOfMonth())
                .append(".")
                .append(flight.getETD().getMonth().toString())
                .append(".")
                .append(flight.getETD().getYear())
                .append("_")
                .append(seat);
        //used stringBuilder to save resources (one String, instead of every String being saved from before and after an addittion)
        return stringl.toString();
    }
}