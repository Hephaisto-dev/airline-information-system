package implementations;

import interfaces.Route;

public class RouteImpl implements Route {
    private String arriveIn;
    private String departFrom;

    public RouteImpl(String from, String to){
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
}
