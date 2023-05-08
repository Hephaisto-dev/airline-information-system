package businesslogic.api.booking;

import datarecords.BookingData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookingFactoryTest {

    @Test
    void createBookingWithData() {
        BookingData bookingData = new BookingData(null, null, null, null, null, null, null);
        Booking booking = BookingFactory.createBooking(bookingData);
        assertThat(booking.getData()).isEqualTo(bookingData);
    }

    @Test
    void testCreateBooking() {
        Booking booking = BookingFactory.createBooking("id", "empid", null, null, null, null, null);
        SoftAssertions.assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(booking.getId()).isEqualTo("id");
                    softAssertions.assertThat(booking.getEmp()).isEqualTo("empid");
                }
        );
    }
}