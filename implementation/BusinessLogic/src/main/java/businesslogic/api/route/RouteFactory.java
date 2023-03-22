package businesslogic.api.route;

import businesslogic.api.airport.Airport;
import businesslogic.implementation.RouteImpl;

public interface RouteFactory {
    static Route createRoute(Airport from, Airport to) {
        return new RouteImpl(from, to);
    }
}
