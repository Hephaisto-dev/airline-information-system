package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.flight.Flight;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FlightImplTest {

    private final String from = "DEPART";
    private final String to = "ARRIVE";
    private final LocalDateTime LDTd = LocalDateTime.of(2012, 12, 11, 5, 3);
    private final LocalDateTime LDTa = LocalDateTime.of(2012, 12, 11, 8, 23);
    private final LocalDateTime LDTd2 = LocalDateTime.of(2012, 12, 15, 12, 34);
    private final LocalDateTime LDTa2 = LocalDateTime.of(2012, 12, 15, 15, 45);
    private final Duration dur = Duration.between(LDTd, LDTa);
    //String, String, LocalDateTime, LocalDateTime, Airplane
    private final Duration dur2 = Duration.between(LDTd2, LDTa2);
    private final Airplane plane = new AirplaneImpl("Hello", "There", 3);
    private final Airplane plane2 = new AirplaneImpl("Identification", "please", 123);
    //String, String, LocalDateTime, LocalDateTime, Duration, Airplane
    private final Airplane plane3 = new AirplaneImpl("Wherever", "you are", 1912);
    private final Flight FlightOne = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), LDTd, LDTa, dur, plane);
    private final Flight FlightTwo = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), LDTd, LDTa, plane2);
    private final Flight FlightThree = new FlightImpl(AirportFactory.createAirport("Near"),
            AirportFactory.createAirport("Far"), LDTd2, LDTa2, plane3);
    private final Flight TooLongFlight = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), LDTd, LDTa2, plane2);

    @Test
    void getId() {
    }

    @Test
    void getFlightDuration() {
        long expectedHours = 3;
        long expectedMinutes = 20;

        long actualHours = dur.toHours();
        long actualMinutes = dur.toMinutes() % 60;

        assertEquals(expectedHours, actualHours);
        assertEquals(expectedMinutes, actualMinutes);
    }

    // airplane info testing start
    @Test
    void testGetPlaneId1() {
        assertThat(plane.getId())
                .isEqualTo("Hello");
    }

    @Test
    void testGetPlaneName1() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane.getName())
                    .isEqualTo("There");
        });
    }

    @Test
    void testGetPlaneCapacity1() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane.getCapacity())
                    .isEqualTo(3);
        });
    }

    @Test
    void testGetPlaneId2() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane2.getId())
                    .isEqualTo("Identification");
        });
    }


    @Test
    void testGetPlaneName2() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane2.getName())
                    .isEqualTo("please");
        });
    }

    @Test
    void testGetPlaneCapacity2() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane2.getCapacity())
                    .isEqualTo(123);
        });
    }

    @Test
    void testGetPlaneId3() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane3.getId())
                    .isEqualTo("Wherever");
        });
    }

    @Test
    void testGetPlaneName3() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane3.getName())
                    .isEqualTo("you are");
        });
    }

    @Test
    void testGetPlaneCapacity3() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(plane3.getCapacity())
                    .isEqualTo(1912);
        });
    }

    // airplane info test end

    @Test
    void getETD() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(LDTd.getDayOfMonth())
                    .as("Day of month should be 11")
                    .isEqualTo(11);
            softly.assertThat(LDTd.getMonthValue())
                    .as("Month value should be 12")
                    .isEqualTo(12);
            softly.assertThat(LDTd.getYear())
                    .as("Year should be 2012")
                    .isEqualTo(2012);
            softly.assertThat(LDTd.getHour())
                    .as("Hour should be 5")
                    .isEqualTo(5);
            softly.assertThat(LDTd.getMinute())
                    .as("Minute should be 3")
                    .isEqualTo(3);
        });
    }

    @Test
    void getETA() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(LDTa.getDayOfMonth())
                    .as("Day of month should be 11")
                    .isEqualTo(11);
            softly.assertThat(LDTa.getMonthValue())
                    .as("Month value should be 12")
                    .isEqualTo(12);
            softly.assertThat(LDTa.getYear())
                    .as("Year should be 2012")
                    .isEqualTo(2012);
            softly.assertThat(LDTa.getHour())
                    .as("Hour should be 8")
                    .isEqualTo(8);
            softly.assertThat(LDTa.getMinute())
                    .as("Minute should be 23")
                    .isEqualTo(23);
        });
    }

    @Test
    void getDepartureAirport() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(from)
                    .isEqualTo("DEPART");
        });
    }

    @Test
    void getArrivalAirport() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(to)
                    .isEqualTo("ARRIVE");
        });
    }
}