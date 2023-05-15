package businesslogic.impl;


import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import datarecords.AirplaneData;
import org.junit.jupiter.api.BeforeAll;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BookingImplTest {

    private static final List<String> tickets = new ArrayList<>();//TODO WHEN TICKETS ARE IMPLEMENTED CHANGE THIS
    private final List<String> extras = new ArrayList<>();
    // private List<CustomerData> customers = new ArrayList<>();//TODO when customers are finished implement this

    private final Airplane airplane = new AirplaneImpl(new AirplaneData("ids", "manufacturers", 7, 7, "models", 77));
    private final Airport airport1 = new AirportImpl("1", "MyHouse", "Netherlands");
    private final Airport airport2 = new AirportImpl("2", "YourHouse", "Netherlands");
    private final Duration duration = Duration.ofDays(10);

    //private final Booking booking = new BookingImpl("1","1",flightIds,ticketIds,LocalDateTime.now(),extraIds,);

    @BeforeAll
    static void prepare() {
        tickets.add("ticket1");
        tickets.add("ticket2");
        tickets.add("ticket3");
        tickets.add("ticket4");
        //TODO when customers are finished update this


    }

}
