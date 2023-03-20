package businesslogic.api.route;

import businesslogic.implementation.RouteImpl;

public interface RouteFactory {
    static Route createRoute(String from, String to) {
        return new RouteImpl(from, to);
    }
}
