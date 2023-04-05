package businesslogic.implementation;

import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.route.Route;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RouteImplTest {

    private final Route route = new RouteImpl(AirportFactory.createAirport("DEPART"),
            AirportFactory.createAirport("ARRIVE"));

    RouteImplTest() throws NoAirportException {
    }

    @Test
    void getDeparturePlace() {
        assertThat(route.getFrom().getName())
                .isEqualTo("DEPART");
    }

    @Test
    void getArrivalPlace() {
        assertThat(route.getTo().getName())
                .isEqualTo("ARRIVE");
    }

    @Test
    void testToString() {
        assertThat(route.toString())
                .isEqualTo("DEPART -> ARRIVE");
    }
}