package businesslogic.api.route;

import businesslogic.api.airport.Airport;
import datarecords.RouteData;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteCreator {
    public String createRoute(String departPlace, String arrivePlace) {
        boolean errors = false;
        Airport departAirport = null;
        Airport arriveAirport = null;
        StringBuilder stringBuilder = new StringBuilder();


/*        try {
            departAirport = AirportFactory.createAirport(departPlace);
        } catch (NoAirportException a) {
            errors = true;
            stringBuilder.append("Departure Airport does not exist in our database\n");
        }
        try {
            arriveAirport = AirportFactory.createAirport(arrivePlace);
        } catch (NoAirportException a) {
            errors = true;
            stringBuilder.append("Arrival Airport does not exist in our database\n");
        }*/

        if (!errors) {
            Route route = RouteFactory.createRoute(new RouteData("RT_", new HashMap<>()));
            // flightManager.add(flight);
            return "Route was successfully created";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
