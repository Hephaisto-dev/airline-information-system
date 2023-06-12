package businesslogic.api.booking;

import datarecords.BookingData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingFactoryTest {
    private List<String> customerIds = new ArrayList<>();

    @Test
    void createBooking() {
        customerIds.add("1");
        BookingData bookingData = new BookingData("1", "1", customerIds, LocalDate.now(), null, "1", "1");

        Booking booking = BookingFactory.createBooking(bookingData);
        assertEquals(booking.getData(), bookingData);
    }
}
