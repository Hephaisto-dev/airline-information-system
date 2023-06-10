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

    static Airport createAirport(String id, String name, String country) {
        return new AirportImpl(id, name, country);
    }
}
