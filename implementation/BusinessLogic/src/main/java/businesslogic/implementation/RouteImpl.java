package businesslogic.implementation;

import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.route.Route;
import datarecords.RouteData;

public class RouteImpl implements Route {
    protected final RouteData routeData;
    private final Airport departureAirport;
    private final Airport arrivalAirport;

    public RouteImpl(Airport from, Airport to) {
        this.routeData = new RouteData(from.getAirportData(), to.getAirportData());
        this.departureAirport = from;
        this.arrivalAirport = to;
    }

    public RouteImpl(RouteData routeData) {
        this.routeData = routeData;
        this.departureAirport = AirportFactory.createAirport(routeData.from());
        this.arrivalAirport = AirportFactory.createAirport(routeData.to());
    }

    @Override
    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    @Override
    public Airport getArrivalAirport() {
        return this.arrivalAirport;
    }

    @Override
    public String toString() {
        return "RouteImpl{" +
                "routeData=" + routeData +
                '}';
    }

    @Override
    public RouteData getRouteData() {
        return routeData;
    }
}
