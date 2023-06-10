package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.api.customer.Price;
import businesslogic.api.customer.PriceImpl;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
import datarecords.AirplaneData;
import datarecords.FlightData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class FlightImplTest {

    private final String from = "DEPART";
    private final String to = "ARRIVE";
    private final Price cost = new PriceImpl(1250);
    private final LocalDateTime ldtd = LocalDateTime.of(2012, 12, 11, 5, 3);
    private final LocalDateTime ldta = LocalDateTime.of(2012, 12, 11, 8, 23);
    private final LocalDateTime ldtd2 = LocalDateTime.of(2012, 12, 15, 12, 34);
    private final LocalDateTime ldta2 = LocalDateTime.of(2012, 12, 15, 15, 45);
    private final Duration dur = Duration.between(ldtd, ldta);
    private final Flight flight1;
    //private final Flight flight1;
    private final Duration dur2 = Duration.between(ldtd2, ldta2);
    private final Flight flightThree;
    private final Flight flightTwo;
    //private final Flight flightThree;
    private final Duration dur3 = Duration.between(ldtd, ldta2);
    private final Flight tooLongFlight;
    private final Airplane plane = new AirplaneImpl(new AirplaneData("Hello", "There", 3, 3, "model", 55));
    private final Airplane plane2 = new AirplaneImpl(new AirplaneData("Identification", "please", 123, 2, "model", 55));

    public FlightImplTest() {
        tooLongFlight = FlightFactory.createFlight(new FlightData("FL_DEPART-ARRIVE_2012-12-11T05:03_Identification", ldtd, ldta2, dur3, plane2.getId(), "DEPART", "ARRIVE"));
        flightTwo = FlightFactory.createFlight(new FlightData("FL_DEPART-ARRIVE_2012-12-15T12:34_Identification", ldtd2, ldta2, dur2, plane2.getId(), "DEPART", "ARRIVE"));
        flightThree = FlightFactory.createFlight(new FlightData("", ldtd2, ldta2, dur2, plane2.getId(), "DEPART", "ARRIVE"));
        flight1 = FlightFactory.createFlight(new FlightData("FL_DEPART-ARRIVE_2012-12-11T05:03_Hello", ldtd, ldta, dur, plane.getId(), "DEPART", "ARRIVE"));
    }

    @Disabled
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

    @Disabled
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

    @Disabled
    @Test
    void testGetAirplane() {
        Airplane desiredAirplane = mock(Airplane.class);

        Flight flight = mock(Flight.class);
        when(flight.getAirplane()).thenReturn(desiredAirplane);

        assertSame(desiredAirplane, flight.getAirplane());
    }

    @Disabled
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

    @Disabled
    @Test
    void testArrivalDeparture() {
        Flight flightMock = mock(Flight.class);

        Airport departureMock = mock(Airport.class);
        Airport arrivalMock = mock(Airport.class);

        when(departureMock.getName()).thenReturn("DEPART");
        when(arrivalMock.getName()).thenReturn("ARRIVE");

        when(flightMock.getDeparture()).thenReturn(departureMock);
        when(flightMock.getArrival()).thenReturn(arrivalMock);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flightMock.getDeparture().getName()).isEqualTo("DEPART");
            softly.assertThat(flightMock.getArrival().getName()).isEqualTo("ARRIVE");
        });
    }

    @Disabled
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

    @Disabled
    @Deprecated(forRemoval = true)
    @Test
    void testToString() {
        Flight flightMock = mock(Flight.class);

        when(flightMock.toString()).thenReturn("FlightImpl{flightData=<flightData_placeholder>" +
                ", airplane=" + plane + '}');

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flightMock.toString())
                    .isEqualTo("FlightImpl{flightData=<flightData_placeholder>" +
                            ", airplane=" + plane + '}');
        });
    }


    @Disabled
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
        Flight flightMock = mock(Flight.class);
        when(flightMock.bookSeat(1, 'B')).thenReturn("already booked");
        when(flightMock.bookSeat(2, 'A')).thenReturn("already booked");
        when(flightMock.bookSeat(number, character)).thenReturn(expectedResult);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(flightMock.bookSeat(1, 'B'))
                    .contains("already booked");
            softly.assertThat(flightMock.bookSeat(2, 'A'))
                    .contains("already booked");
            softly.assertThat(flightMock.bookSeat(number, character))
                    .contains(expectedResult);
        });
    }


    @Disabled
    @Deprecated(forRemoval = true)
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
    /*

     */

    @Disabled
    @Deprecated(forRemoval = true)
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