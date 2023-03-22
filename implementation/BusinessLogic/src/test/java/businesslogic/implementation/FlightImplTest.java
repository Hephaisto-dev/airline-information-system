package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightImplTest {

    private String from = "DEPART";
    private String to = "ARRIVE";
    private LocalDateTime LDTd = LocalDateTime.of(2012,12,11,5,3);
    private LocalDateTime LDTa = LocalDateTime.of(2012,12,11,8,23);
    private LocalDateTime LDTd2 = LocalDateTime.of(2012,12,15,12,34);
    private LocalDateTime LDTa2 = LocalDateTime.of(2012,12,15,15,45);
    private Duration dur = Duration.between(LDTd,LDTa);
    private Duration dur2 = Duration.between(LDTd2, LDTa2);
    private AirplaneImpl plane = new AirplaneImpl("Hello", "There", 3);
    private AirplaneImpl plane2 = new AirplaneImpl("Identification", "please", 123);
    private AirplaneImpl plane3 = new AirplaneImpl("Wherever", "you are", 1912);

    //String, String, LocalDateTime, LocalDateTime, Duration, Airplane

    //String, String, LocalDateTime, LocalDateTime, Airplane
    private FlightImpl FlightOne = new FlightImpl(from, to, LDTd, LDTa, dur, plane);
    private FlightImpl FlightTwo = new FlightImpl(from, to , LDTd, LDTa, plane2);
    private FlightImpl FlightThree = new FlightImpl("Near", "Far", LDTd2, LDTa2, plane3);
    private FlightImpl TooLongFlight = new FlightImpl(from, to , LDTd, LDTa2, plane2);

    /*
    SoftAssertions.assertSoftly(softly->{
            softly.assertThat(Route.getDeparturePlace())
                    .isEqualTo("DEPART");
        });
     */

    @Test
    void getId() {
    }

    @Test
    void getFlightDuration() {
    }

    @Test
    void getAirplane() {
    }

    @Test
    void getETD() {
    }

    @Test
    void getETA() {
    }

    @Test
    void getDepartureAirport() {
    }

    @Test
    void getArrivalAirport() {
    }

    @Test
    void testToString() {
    }
}