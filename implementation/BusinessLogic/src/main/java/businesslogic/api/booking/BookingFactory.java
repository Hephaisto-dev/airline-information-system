package businesslogic.api.booking;

import businesslogic.api.airplane.NoAirplaneException;
import businesslogic.implementation.BookingImpl;
import datarecords.BookingData;
import datarecords.CustomerData;
import datarecords.FlightData;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingFactory {
    static Booking createBooking(String id, String empId, FlightData flight, List<String> Tickets, LocalDateTime bookingDate, List<String> extras, List<CustomerData> customersOnBooking) {
        return new BookingImpl(id, empId, flight, Tickets, bookingDate, extras, customersOnBooking);
    }

    static Booking createBooking(BookingData bookingData) throws NoAirplaneException, NoBookingException {
        if (true) {//TODO implement the getting from the persistence / DB
            return new BookingImpl(bookingData);
        } else {
            throw new NoBookingException();
        }
    }
}
