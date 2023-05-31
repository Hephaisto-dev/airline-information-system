package businesslogic.api.booking;

import businesslogic.api.airplane.NoAirplaneException;
import businesslogic.api.customer.Customer;
import businesslogic.api.customer.Ticket;
import businesslogic.impl.BookingImpl;
import datarecords.BookingData;

public interface BookingFactory {
    static Booking createBooking(BookingData bookingData) {
        return new BookingImpl(bookingData);
    }
}
