package businesslogic.api.airport;

import businesslogic.impl.AirportImpl;
import datarecords.AirportData;

public interface AirportFactory {
    static Airport createAirport(String id, String name, String city, String country) {
        return new AirportImpl(id, name, city, country);
    }

    static Airport createAirport(AirportData airportData) {
        return new AirportImpl(airportData);
    }

    static Airport createAirport(String name) throws NoAirportException {
        if (true) { //TODO implement the getting from the persistence / DB
            return new AirportImpl("AI",name,"","");
        } else {
            throw new NoAirportException();
        }
    }

//    static Airport createAirport(){
//
//    }
}
