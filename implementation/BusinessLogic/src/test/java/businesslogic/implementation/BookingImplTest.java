package businesslogic.implementation;

import businesslogic.api.airport.Airport;
import businesslogic.api.booking.Booking;
import businesslogic.api.airplane.Airplane;
import businesslogic.api.flight.Flight;
import datarecords.CustomerData;
import org.junit.jupiter.api.BeforeAll;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingImplTest {

    private static ArrayList<String> tickets = new ArrayList<>();//TODO WHEN TICKETS ARE IMPLEMENTED CHANGE THIS

    private ArrayList<String> extras = new ArrayList<>();
   // private ArrayList<CustomerData> customers = new ArrayList<>();//TODO when customers are finished implement this

    private final Airplane airplane = new AirplaneImpl("1","BigPlane",200);
    private final Airport airport1 = new AirportImpl("1","MyHouse","Venlo","Netherlands");
    private final Airport airport2 = new AirportImpl("2","YourHouse","Venlo","Netherlands");
    private final Duration duration = Duration.ofDays(10);
    private final Flight flight= new FlightImpl(airport1,airport2, LocalDateTime.now().plusDays(20),LocalDateTime.now().plusDays(10),duration,airplane);

    //private final Booking booking = new BookingImpl("1","1",flight,tickets,LocalDateTime.now(),extras,);

    @BeforeAll
    static void prepare() {
        tickets.add("ticket1");
        tickets.add("ticket2");
        tickets.add("ticket3");
        tickets.add("ticket4");
        //TODO when customers are finished update this


    }

}
