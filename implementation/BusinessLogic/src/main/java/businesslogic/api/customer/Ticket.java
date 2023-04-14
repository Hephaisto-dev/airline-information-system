package businesslogic.api.customer;

import businesslogic.api.airplane.Seat;
import businesslogic.api.common.StringIdentifiable;
import businesslogic.api.flight.Flight;

public interface Ticket extends StringIdentifiable {

    String getTicketOwner();

    Flight getFlight();

    String getSeatName();

    Seat getSeat();

    String getRouteDescription();

    void applyDiscount(int discount);

    void applyVoucher(int percentReduction);

    Price getPrice();

}
