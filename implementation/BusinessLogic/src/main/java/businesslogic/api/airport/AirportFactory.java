package businesslogic.api.airport;

import businesslogic.implementation.AirportImpl;
import datarecords.AirportData;

public interface AirportFactory {
    static Airport createAirport(String id, String name, String city, String country) {
        return new AirportImpl(id, name, city, country);
    }

    static Airport createAirport(AirportData airportData) {
        return new AirportImpl(airportData);
    }

    static Airport createAirport(String name) {
        return new AirportImpl("AI", name, "", "");
    }

    static AirportImpl createAirportImpl(String name) {
        return new AirportImpl("AI", name, "", "");
    }
}
