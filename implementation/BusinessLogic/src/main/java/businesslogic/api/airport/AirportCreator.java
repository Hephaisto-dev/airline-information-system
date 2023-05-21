package businesslogic.api.airport;

import businesslogic.api.manager.AirportManager;

public class AirportCreator {

    private final AirportManager airportManager;

    public AirportCreator(AirportManager airportManager) {
        this.airportManager = airportManager;
    }

    //change the airport city to dropdown ?
    public String createAirport(String airportName, String airportCountry) {
        boolean errors = false;

        StringBuilder stringBuilder = new StringBuilder();
        //implementation for incorrect id format

        if (airportName == null || airportCountry == null) {
            errors = true;
            stringBuilder.append("All fields must be filled in!");
        }
        //TODO catch persistance exception - NoDBConnectionException
        //        try {
        //
        //        } catch (Exception a) {
        //            errors = true;
        //            stringBuilder.append("Error?!\n");
        //        }

        //TODO Implementation for incorrect id format

        if (!errors) {
            try {
                Airport airport = AirportFactory.createAirport(airportName, airportCountry);
                airportManager.add(airport);
            } catch (Exception e) {
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "+If the issue persists, contact the IT department";
            }
            return "Airport was successfully created";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
