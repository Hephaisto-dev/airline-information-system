package businesslogic.api.booking;

import businesslogic.api.airplane.NoAirplaneException;
import businesslogic.api.customer.Customer;
import businesslogic.api.customer.Ticket;
import businesslogic.implementation.BookingImpl;
import businesslogic.impl.BookingImpl;
import datarecords.BookingData;
import datarecords.CustomerData;
import datarecords.FlightData;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingFactory {
    static Booking createBooking(String id, String empId, FlightData flight, List<String> Tickets, LocalDateTime bookingDate, List<String> extras, List<CustomerData> customersOnBooking) {
        return new BookingImpl(id, empId, flight, Tickets, bookingDate, extras, customersOnBooking);
    }

    static Booking createBooking(BookingData bookingData) {
        return new BookingImpl(bookingData);
    }
}
