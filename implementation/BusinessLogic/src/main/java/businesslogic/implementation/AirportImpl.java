package businesslogic.implementation;

import businesslogic.api.airport.Airport;
import datarecords.AirportData;

public class AirportImpl implements Airport {
    private final AirportData airportData;

    public AirportImpl(String id, String name, String city, String country) {
        this(new AirportData(id, name, city, country));
    }

    public AirportImpl(AirportData airportData) {
        this.airportData = airportData;
    }

    @Override
    public String getCity() {
        return airportData.city();
    }

    @Override
    public String getCountry() {
        return airportData.country();
    }

    @Override
    public AirportData getAirportData() {
        return airportData;
    }

    @Override
    public String getId() {
        return airportData.id();
    }

    @Override
    public String getName() {
        return airportData.name();
    }
}