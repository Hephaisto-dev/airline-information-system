package businesslogic.implementation;

import businesslogic.api.airport.AirportFactory;
import businesslogic.api.route.Route;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RouteImplTest {

    private final Route Route = new RouteImpl(AirportFactory.createAirport("DEPART"),
            AirportFactory.createAirport("ARRIVE"));

    @Test
    void getDeparturePlace() {
        assertThat(Route.getDepartureAirport().getName())
                .isEqualTo("DEPART");
    }

    @Test
    void getArrivalPlace() {
        assertThat(Route.getArrivalAirport().getName())
                .isEqualTo("ARRIVE");
    }

    @Test
    void testToString() {
        assertThat(Route.toString())
                .isEqualTo("DEPART -> ARRIVE");
    }
}