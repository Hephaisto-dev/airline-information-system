package businesslogic.api.customer;

import businesslogic.api.flight.Flight;
import businesslogic.api.route.Route;

public interface Ticket {

    String getTicketID();

    String getTicketOwner();

    Flight getFlight();

    String getSeat();

    String getRouteDescription();

}
