package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.customer.Price;
import businesslogic.api.customer.PriceImpl;
import businesslogic.api.flight.Flight;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.time.LocalDateTime;


class FlightImplTest {

    private final String from = "DEPART";
    private final String to = "ARRIVE";
    private final Price cost = new PriceImpl(1250);
    private final LocalDateTime ldtd = LocalDateTime.of(2012, 12, 11, 5, 3);
    private final LocalDateTime ldta = LocalDateTime.of(2012, 12, 11, 8, 23);
    private final LocalDateTime ldtd2 = LocalDateTime.of(2012, 12, 15, 12, 34);
    private final LocalDateTime ldta2 = LocalDateTime.of(2012, 12, 15, 15, 45);
    private final Duration dur = Duration.between(ldtd, ldta);
    //private final Flight flight1;
    private final Duration dur2 = Duration.between(ldtd2, ldta2);
    //private final Flight flightThree;
    private final Duration dur3;
    private Airplane plane = new AirplaneImpl("Hello", "There", 3, 3);
    private Flight flight1 = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), ldtd, ldta, dur, plane);
    private Airplane plane2 = new AirplaneImpl("Identification", "please", 123, 2);
    private Flight flightThree = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), ldtd2, ldta2, dur2, plane2, cost);
    private final Flight tooLongFlight = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), ldtd, ldta2, plane2);
    private final Flight flightTwo = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), ldtd2, ldta2, plane2);

    FlightImplTest() throws NoAirportException {
        flight1 = new FlightImpl(AirportFactory.createAirport(from),
                AirportFactory.createAirport(to), ldtd, ldta, dur, plane);
        dur3 = Duration.between(ldtd, ldta2);
        flightThree = new FlightImpl(AirportFactory.createAirport(from),
                AirportFactory.createAirport(to), ldtd2, ldta2, dur2, plane2, cost);
    }

    @Test
    void testGetETD() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(flight1.getETD())
                    .isEqualTo(ldtd);
            softAssertions.assertThat(flightTwo.getETD())
                    .isEqualTo(ldtd2);
            softAssertions.assertThat(tooLongFlight.getETD())
                    .isEqualTo(ldtd);
        });
    }

    @Test
    void testGetFlightDuration() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flight1.getFlightDuration())
                    .isEqualTo(dur);
            softly.assertThat(flightTwo.getFlightDuration())
                    .isEqualTo(dur2);
            softly.assertThat(tooLongFlight.getFlightDuration())
                    .isEqualTo(dur3);
        });
    }

    @Test
    void testGetAirplane() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flight1.getAirplane())
                    .isEqualTo(plane);
            softly.assertThat(flightTwo.getAirplane())
                    .isEqualTo(plane2);
            softly.assertThat(tooLongFlight.getAirplane())
                    .isEqualTo(plane2);
        });
    }

    @Test
    void testGetETA() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flight1.getETA())
                    .isEqualTo(ldta);
            softly.assertThat(flightTwo.getETA())
                    .isEqualTo(ldta2);
            softly.assertThat(tooLongFlight.getETA())
                    .isEqualTo(ldta2);
        });
    }

    @Test
    void testArrivalDeparture() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flight1.getDeparture().getName()).isEqualTo("DEPART");
            softly.assertThat(flight1.getArrival().getName()).isEqualTo("ARRIVE");
            softly.assertThat(flightTwo.getDeparture().getName()).isEqualTo("DEPART");
            softly.assertThat(flightTwo.getArrival().getName()).isEqualTo("ARRIVE");
            softly.assertThat(tooLongFlight.getDeparture().getName()).isEqualTo("DEPART");
            softly.assertThat(tooLongFlight.getArrival().getName()).isEqualTo("ARRIVE");
        });
    }

    @Test
    void testGetId() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flight1.getId())
                    .isEqualTo("FL_" + from + "-" + to + "_" +
                            ldtd + "_" + plane.getId());
            softly.assertThat(flightTwo.getId())
                    .isEqualTo("FL_" + from + "-" + to + "_" +
                            ldtd2 + "_" + plane2.getId());
            softly.assertThat(tooLongFlight.getId())
                    .isEqualTo("FL_" + from + "-" + to + "_" +
                            ldtd + "_" + plane2.getId());
        });
    }

    @Test
    void testToString() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flight1.toString())
                    .isEqualTo("FlightImpl{flightData=" + flight1.getData() +
                            ", airplane=" + plane + '}');
            softly.assertThat(flightTwo.toString())
                    .isEqualTo("FlightImpl{flightData=" + flightTwo.getData() +
                            ", airplane=" + plane2 + '}');

            softly.assertThat(tooLongFlight.toString())
                    .isEqualTo("FlightImpl{flightData=" + tooLongFlight.getData() +
                            ", airplane=" + plane2 + '}');
        });
    }

    @Test
    void testETDBeforeETA() {
        Assertions.assertThatThrownBy(() -> new FlightImpl(AirportFactory.createAirport(from),
                        AirportFactory.createAirport(to), ldta, ldtd, plane))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ETD must be before ETA");
    }

    @ParameterizedTest
    @CsvSource({
            "124,B,Row number exceeding",
            "1,A,successfully",
            "12,a,single capital letter",
            "123,1,single capital letter",
            "1,B,already booked",
            "2,A,already booked"
    })
    void testBookingSeat(int number, char character, String expectedResult) {
        SoftAssertions.assertSoftly(softly -> {
            flightTwo.bookSeat(1, 'B');
            flightTwo.bookSeat(2, 'A');
            softly.assertThat(flightTwo.bookSeat(number, character))
                    .contains(expectedResult);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1A,couldn't be found",
            "1B,successfully freed",
            "2A,successfully freed"
    })
    void testCancelBookedSeat(String target, String expect) {
        SoftAssertions.assertSoftly(softly -> {
            flightTwo.bookSeat(1, 'B');
            flightTwo.bookSeat(2, 'A');
            softly.assertThat(flightTwo.cancelBookedSeat(target))
                    .contains(expect);
        });
    }

    @Test
    void testPrice() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flight1.getPrice().getBackendPrice())
                    .isEqualTo(flightTwo.getPrice().getBackendPrice());
            softly.assertThat(flightThree.getPrice().getBackendPrice())
                    .isNotEqualTo(flight1.getPrice().getBackendPrice());
        });
    }
}