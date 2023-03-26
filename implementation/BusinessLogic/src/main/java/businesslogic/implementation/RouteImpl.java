package businesslogic.implementation;

import businesslogic.api.airport.Airport;
import businesslogic.api.route.Route;
import datarecords.RouteData;

public class RouteImpl implements Route {
    protected final RouteData routeData;
    private final Airport from;
    private final Airport to;

    public RouteImpl(Airport from, Airport to) {
        this.routeData = new RouteData(from.getData(), to.getData());
        this.from = from;
        this.to = to;
    }

    @Override
    public Airport getFrom() {
        return this.from;
    }

    @Override
    public Airport getTo() {
        return this.to;
    }

    @Override
    public String toString() {
        return routeData.from().name() + " -> " + routeData.to().name();
    }

    @Override
    public RouteData getRouteData() {
        return routeData;
    }
}
