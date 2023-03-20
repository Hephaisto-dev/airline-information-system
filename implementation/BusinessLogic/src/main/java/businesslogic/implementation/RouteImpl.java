package businesslogic.implementation;

import businesslogic.api.route.Route;

public class RouteImpl implements Route {
    private final String arriveIn;
    private final String departFrom;

    public RouteImpl(String from, String to) {
        this.departFrom = from;
        this.arriveIn = to;
    }

    @Override
    public String getDeparturePlace() {
        return this.departFrom;
    }

    @Override
    public String getArrivalPlace() {
        return this.arriveIn;
    }

    @Override
    public String toString() {
        return "RouteImpl{" +
                "arriveIn='" + arriveIn + '\'' +
                ", departFrom='" + departFrom + '\'' +
                '}';
    }
}
