package businesslogic.api.route;

import businesslogic.api.manager.RouteManager;
import datarecords.RouteData;

import java.util.HashMap;
import java.util.Map;

public class RouteCreator {

    private final RouteManager routeManager;
    private final StringBuilder stringBuilder = new StringBuilder();
    private int flightIdCounter;
    private int flightTransitTimeCounter;

    public RouteCreator(RouteManager manage) {
        this.routeManager = manage;

    }

    public String createRoute(String name, String id, Map<String, Long> flightIdAndtransit, int price, HashMap<Integer, String> rawTransits) throws Exception {
        boolean errors = false;

        /*
         * Goes through the Hashmap from the smallest index to the max
         * and replaces the empty values(gaps in the indexes) with dashes
         * so they can be checked later
         */
        if (name == null || name.isEmpty()) {
            stringBuilder.append("Please enter a name for the Special Route!\\n");
            errors = true;
        } else if (name.length() < 10) {
            stringBuilder.append("The name of the Special Route has to be at least 10 characters long!\\n");
            errors = true;
        } else if (!name.matches("[^a-zA-Z0-9\\s]")) {
            errors = true;
            stringBuilder.append("The name of the Special Route can not contain any special characters!\\n");
        }


        //check that the number of transits should be equal to the number of flights minus 1
        flightIdAndtransit.forEach((flightId, transitTimeInSeconds) -> {
            flightIdCounter++;
            if (transitTimeInSeconds != 0) {

                flightTransitTimeCounter++;
            }
        });
        if (flightIdCounter != flightTransitTimeCounter + 1) {
            stringBuilder.append("Incorrect number of transit times! For n number of flights there has to be n-1 number of" +
                    "transit times! \\n");
            errors = true;
        }
        if (flightIdCounter < 2) {
            stringBuilder.append("The number of flights in the route have to be at least 2!");
            errors = true;
        }


        int[] smallestPositionInHM = {50};
        int[] largestPositionInHM = {0};
        rawTransits.forEach((key, value) -> {
            if (smallestPositionInHM[0] > key) smallestPositionInHM[0] = key;
            if (key > largestPositionInHM[0]) largestPositionInHM[0] = key;
        });
        for (int i = smallestPositionInHM[0]; i < largestPositionInHM[0] + 1; i++) {
            if (!rawTransits.containsKey(i)) rawTransits.put(i, "--");
        }

        for (Integer key : rawTransits.keySet()) {
            String value = rawTransits.get(key);

            String[] parts = value.split("[dhw]");

            if (!value.matches("\\d+h") && !value.matches("\\d+d") && !value.matches("\\d+w")) {
                stringBuilder.append("Incorrect transit time format! Please use either digit+h, digit+d pr digit+w");
                throw new IncorrectTransitTimeFormatException("Incorrect transit time format! Please use either digit+h, digit+d pr digit+w");
            }
            if (value.matches("[^a-zA-Z0-9\\s]")) {
                stringBuilder.append("You can not enter special characters in transit time!\\n");
                throw new IncorrectTransitTimeFormatException("You can not enter special characters in transit time!");
            }
            if (value.matches("\\d+h") && Integer.parseInt(parts[0]) < 24) {
                errors = true;
                stringBuilder.append("The transit time has to be at least 24 hours!\\n");
            }
            if (value.matches("\\d+d") && Integer.parseInt(parts[0]) > 30) {
                errors = true;
                stringBuilder.append("Transit time can not be more than 30 days!\\n");
            }
            if (value.matches("\\d+w") && Integer.parseInt(parts[0]) > 4) {
                stringBuilder.append("Transit time can not be more than 4 weeks!\\n");
                throw new IncorrectTimeException("less than 4 weeks" + stringBuilder.append("Transit time can not be more than 4 weeks!\\n"));
            }
            if (value.matches("[\\s]")) {
                stringBuilder.append("No whitespaces are allowed when entering transit time!\\n");
                errors = true;
//                throw new IncorrectTransitTimeFormatException("No whitespaces are allowed when entering transit time!");
            }
            if (rawTransits.containsValue("--")) {
                stringBuilder.append("The transit times should be entered in order without skipping any!\\n");
                throw new IncorrectTransitTimeFormatException("The transit times should be entered in order without skipping any!");
            }
            if (Integer.parseInt(parts[0]) == 0) {
                stringBuilder.append("Please enter at least one transit time!\\n");
                throw new IncorrectTransitTimeFormatException("Please enter at least one transit time!");
            }
        }

        if (!errors) {
            Route route = RouteFactory.createRoute(new RouteData(name, id, flightIdAndtransit, price));
            routeManager.add(route);
            return "Route was created successfully";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
