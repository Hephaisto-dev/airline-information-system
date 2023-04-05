package businesslogic.api.booking;

import businesslogic.api.manager.BookingManager;
import businesslogic.api.manager.FlightManager;
import datarecords.CustomerData;
import datarecords.FlightData;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingCreator {
    private final BookingManager bookingManager;

    public BookingCreator(BookingManager manage) {
        this.bookingManager = manage;    }
    public String CreateBooking(String id, String empId, FlightData flight, ArrayList<String> Tickets, LocalDateTime bookingDate, ArrayList<String> extras, ArrayList<CustomerData> customersOnBooking){

        //TODO ADD RESTRICTIONS
        Booking booking = BookingFactory.createBooking(id,empId,flight,Tickets,bookingDate,extras,customersOnBooking);

        bookingManager.add(booking);
        return"Successfully Created Booking :)";
    }
}
