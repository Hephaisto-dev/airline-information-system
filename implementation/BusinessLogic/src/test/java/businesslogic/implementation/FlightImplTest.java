package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.flight.Flight;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;


class FlightImplTest {

    private final String from = "DEPART";
    private final String to = "ARRIVE";
    private final LocalDateTime ldtd = LocalDateTime.of(2012, 12, 11, 5, 3);
    private final LocalDateTime ldta = LocalDateTime.of(2012, 12, 11, 8, 23);
    private final LocalDateTime ldtd2 = LocalDateTime.of(2012, 12, 15, 12, 34);
    private final LocalDateTime ldta2 = LocalDateTime.of(2012, 12, 15, 15, 45);
    private final Duration dur = Duration.between(ldtd, ldta);
    private final Duration dur2 = Duration.between(ldtd2, ldta2);
    private final Duration dur3 = Duration.between(ldtd, ldta2);
    private final Airplane plane = new AirplaneImpl("Hello", "There", 3);
    private final Flight flightOne = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), ldtd, ldta, dur, plane);
    private final Airplane plane2 = new AirplaneImpl("Identification", "please", 123);
    private final Flight flightTwo = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), ldtd2, ldta2, plane2);
    private final Flight tooLongFlight = new FlightImpl(AirportFactory.createAirport(from),
            AirportFactory.createAirport(to), ldtd, ldta2, plane2);

    FlightImplTest() throws NoAirportException {
    }

    @Test
    void testGetETD() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(flightOne.getETD())
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
            softly.assertThat(flightOne.getFlightDuration())
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
            softly.assertThat(flightOne.getAirplane())
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
            softly.assertThat(flightOne.getETA())
                    .isEqualTo(ldta);
            softly.assertThat(flightTwo.getETA())
                    .isEqualTo(ldta2);
            softly.assertThat(tooLongFlight.getETA())
                    .isEqualTo(ldta2);
        });
    }

    @Test
    void testGetRoute() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flightOne.getRoute().getFrom().getName()).isEqualTo("DEPART");
            softly.assertThat(flightOne.getRoute().getTo().getName()).isEqualTo("ARRIVE");
            softly.assertThat(flightTwo.getRoute().getFrom().getName()).isEqualTo("DEPART");
            softly.assertThat(flightTwo.getRoute().getTo().getName()).isEqualTo("ARRIVE");
            softly.assertThat(tooLongFlight.getRoute().getFrom().getName()).isEqualTo("DEPART");
            softly.assertThat(tooLongFlight.getRoute().getTo().getName()).isEqualTo("ARRIVE");
        });
    }

    @Test
    void testGetId() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flightOne.getId())
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
            softly.assertThat(flightOne.toString())
                    .isEqualTo("FlightImpl{flightData=" + flightOne.getData() +
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
}