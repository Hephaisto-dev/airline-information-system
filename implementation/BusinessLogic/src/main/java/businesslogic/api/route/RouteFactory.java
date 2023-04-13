package businesslogic.api.route;

import businesslogic.implementation.RouteImpl;
import datarecords.RouteData;

public interface RouteFactory {
    static Route createRoute(RouteData routeData) {
        return new RouteImpl(routeData);
    }
}
