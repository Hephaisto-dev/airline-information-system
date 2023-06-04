package businesslogic.impl;


import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.api.baggage.Baggage;
import businesslogic.api.booking.Booking;
import datarecords.AirplaneData;
import datarecords.BookingData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import businesslogic.api.booking.BookingFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingImplTest {

    private static final List<String> tickets = new ArrayList<>();//TODO WHEN TICKETS ARE IMPLEMENTED CHANGE THIS
    private final List<String> extras = new ArrayList<>();
    // private List<CustomerData> customers = new ArrayList<>();//TODO when customers are finished implement this

    private final Airplane airplane = new AirplaneImpl(new AirplaneData("id", "manufacturers", 7, 7, "models", 77));
    private final Airport airport1 = new AirportImpl("1", "MyHouse", "Netherlands");
    private final Airport airport2 = new AirportImpl("2", "YourHouse", "Netherlands");
    private final Duration duration = Duration.ofDays(10);
    private List<String> customerIds = new ArrayList<>();


    @BeforeAll
    static void prepare() {


    }

    @Test
    void testGetters() {
        customerIds.add("1");
        BookingData bookingData = new BookingData("1", "1", customerIds, LocalDate.now(), null, "1", "1");
        Booking booking = BookingFactory.createBooking(bookingData);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(booking.getId()).isEqualTo("1");
            softly.assertThat(booking.getData()).isEqualTo(bookingData);
        });

    }
}