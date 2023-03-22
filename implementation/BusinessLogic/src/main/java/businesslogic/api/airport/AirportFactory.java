package businesslogic.api.airport;

import businesslogic.implementation.AiportImpl;
import datarecords.AirportData;

public interface AirportFactory {
    static Airport createAirport(Integer id, String name, String city, String country) {
        return new AiportImpl(id, name, city, country);
    }

    static Airport createAirport(AirportData airportData) {
        return new AiportImpl(airportData);
    }

    static Airport createAirport(String name) {
        return new AiportImpl(0, name, "", "");
    }
}
