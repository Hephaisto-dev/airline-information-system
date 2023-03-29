package businesslogic.implementation;

import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.route.Route;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RouteImplTest {

    private final Route Route = new RouteImpl(AirportFactory.createAirport("DEPART"),
            AirportFactory.createAirport("ARRIVE"));

    RouteImplTest() throws NoAirportException {
    }

    @Test
    void getDeparturePlace() {
        assertThat(Route.getFrom().getName())
                .isEqualTo("DEPART");
    }

    @Test
    void getArrivalPlace() {
        assertThat(Route.getTo().getName())
                .isEqualTo("ARRIVE");
    }

    @Test
    void testToString() {
        assertThat(Route.toString())
                .isEqualTo("DEPART -> ARRIVE");
    }
}