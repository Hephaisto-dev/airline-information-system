package businesslogic.api.airport;

import businesslogic.implementation.AirportImpl;
import datarecords.AirportData;

public interface AirportFactory {
    static Airport createAirport(Integer id, String name, String city, String country) {
        return new AirportImpl(id, name, city, country);
    }

    static Airport createAirport(AirportData airportData) {
        return new AirportImpl(airportData);
    }

    static Airport createAirport(String name) {
        return new AirportImpl(0, name, "", "");
    }
}
