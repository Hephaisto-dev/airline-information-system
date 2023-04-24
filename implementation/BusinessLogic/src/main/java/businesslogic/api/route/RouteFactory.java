package businesslogic.api.route;

import businesslogic.impl.RouteImpl;
import datarecords.RouteData;

public interface RouteFactory {
    static Route createRoute(RouteData routeData) {
        return new RouteImpl(routeData);
    }
}
