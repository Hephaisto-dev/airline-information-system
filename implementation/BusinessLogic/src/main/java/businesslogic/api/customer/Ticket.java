package businesslogic.api.customer;

import businesslogic.api.flight.Flight;

public interface Ticket {

    String getTicketID();

    String getTicketOwner();

    Flight getFlight();

    String getSeat();

    String getRouteDescription();

}
