package businesslogic.impl;

import businesslogic.api.route.Route;
import datarecords.RouteData;

import java.util.Map;

public class RouteImpl implements Route {
    private final RouteData routeData;

    public RouteImpl(RouteData routeData) {
        this.routeData = routeData;
    }

    @Override
    public String getId() {
        return routeData.id();
    }

    @Override
    public Map<String,Long> getFlightIdAndTransit(){
        return routeData.flightIdsAndTransits();
    }


    @Override
    public RouteData getRouteData() {
        return routeData;
    }
    @Override
    public RouteData getData() {
        return routeData;
    }

//    @Override
//    public Set<Flight> getFlights() {
//        return BusinessLogicFactory.getImplementation().getFlightManager().getAll().stream()
//                .filter(flight -> routeData.flightIds().contains(flight.getId()))
//                .collect(Collectors.toSet());
//    }
    @Override
    public int getPrice(){
        return routeData.price();
    }
    @Override
    public String getName(){
        return routeData.name();
    }

    @Override
    public String toString() {
        return routeData.id();
    }
}
