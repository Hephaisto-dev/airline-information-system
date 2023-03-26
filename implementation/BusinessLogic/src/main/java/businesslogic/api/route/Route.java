package businesslogic.api.route;

import businesslogic.api.airport.Airport;
import datarecords.RouteData;

public interface Route {
    Airport getFrom();

    Airport getTo();

    RouteData getRouteData();
}
