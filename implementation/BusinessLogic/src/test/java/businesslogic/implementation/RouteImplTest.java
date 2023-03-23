package businesslogic.implementation;

import businesslogic.api.airport.AirportFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class RouteImplTest {

    private RouteImpl Route = new RouteImpl(AirportFactory.createAirport("DEPART"),
            AirportFactory.createAirport("ARRIVE"));

    @Test
    void getDeparturePlace() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Route.getDepartureAirport().getName())
                    .isEqualTo("DEPART");
        });
    }

    @Test
    void getArrivalPlace() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Route.getArrivalAirport().getName())
                    .isEqualTo("ARRIVE");
        });
    }

    @Test
    void testToString() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Route.toString())
                    .isEqualTo("DEPART -> ARRIVE");
        });
    }
}