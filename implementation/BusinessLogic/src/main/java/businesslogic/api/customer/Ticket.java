package businesslogic.api.customer;

import businesslogic.api.flight.Flight;

public interface Ticket {

    String getTicketID();

    String getTicketOwner();

    Flight getFlight();

    String getSeat();

    String getRouteDescription();

    void applyDiscount(int discount);

    void applyVoucher(int percentReduction);

    Price getPrice();
}
