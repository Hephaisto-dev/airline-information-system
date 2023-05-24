package businesslogic.api.airport;

import businesslogic.impl.AirportImpl;
import datarecords.AirportData;

public interface AirportFactory {
    static Airport createAirport(String name, String country) {
        String id = "AIR_" + name + ":" + country;
        return createAirport(id, name, country);
    }

    static Airport createAirport(AirportData airportData) {
        return new AirportImpl(airportData);
    }

    static Airport createAirport(String name) throws NoAirportException {
        if (true) { //TODO implement the getting from the persistence / DB
            return new AirportImpl("AI", name, "");
        } else {
            throw new NoAirportException();
        }
    }

    static Airport createAirport(String id, String name, String country) {
        return createAirport(new AirportData(id, name, country));
    }
}
