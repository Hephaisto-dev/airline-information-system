package businesslogic.api.route;

import businesslogic.api.airport.Airport;
import datarecords.RouteData;

public interface Route {
    Airport getDepartureAirport();

    Airport getArrivalAirport();

    RouteData getRouteData();
}
