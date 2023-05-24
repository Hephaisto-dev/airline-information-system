package businesslogic.api.booking;

import businesslogic.impl.BookingImpl;
import datarecords.BookingData;

public interface BookingFactory {
    static Booking createBooking(BookingData bookingData) {
        return new BookingImpl(bookingData);
    }
}
