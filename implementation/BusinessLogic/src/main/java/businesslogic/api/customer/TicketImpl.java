package businesslogic.api.customer;


import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.airplane.Seat;
import businesslogic.api.flight.Flight;
import datarecords.TicketData;

public class TicketImpl implements Ticket {

    private final String person;
    private final Flight flight;
    private final String ticketID;
    private final String seat;
    private final String route;
    private final Price ticketPrice;

    public TicketImpl(String who, Flight flyingFromTo, String sittingPlace, Price price) {
        this.person = who;
        this.flight = flyingFromTo;
        this.seat = sittingPlace;
        this.ticketID = createID();
        this.route = flight.getDeparture().getName() + "-" + flight.getArrival().getName();
        this.ticketPrice = price;
    }

    public TicketImpl(TicketData ticketData) {
        //String id, String flightId, String customerId, int price, String seatId
        this.ticketID = ticketData.id();
        this.flight = BusinessLogicFactory.getImplementation().getFlightManager().getById(ticketData.flightId());

        this.route = flight.getDeparture().getName() + "-" + flight.getArrival().getName();
        this.person = ticketData.customerId();
        this.ticketPrice = new PriceImpl(ticketData.price());
        this.seat = ticketData.seatId();
    }

    @Override
    public String getId() {
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
    public String getSeatName() {
        return this.seat;
    }

    @Override
    public Seat getSeat() {
        return this.flight.getSeat(seat);
    }

    @Override
    public String getRouteDescription() {
        return this.route;
    }

    @Override
    public void applyDiscount(int discount) {
        this.ticketPrice.applyDiscount(discount);
    }

    @Override
    public void applyVoucher(int percentReduction) {
        this.ticketPrice.applyVoucher(percentReduction);
    }

    @Override
    public Price getPrice() {
        return this.ticketPrice;
    }

    private String createID() {
        String stringl = "Ti_" +
                flight.getAirplane().getId() +
                ":" +
                flight.getDeparture().getName() +
                "-" +
                flight.getArrival().getName() +
                "_" +
                flight.getETD().getDayOfMonth() +
                "." +
                flight.getETD().getMonth().toString() +
                "." +
                flight.getETD().getYear() +
                "_" +
                seat;
        //used stringBuilder to save resources (one String, instead of every String being saved from before and after an addittion)
        return stringl;
    }

    @Override
    public TicketData getData() {
        return new TicketData(createID(), flight.getId(), person, ticketPrice.getBackendPrice(), seat);
    }
}
