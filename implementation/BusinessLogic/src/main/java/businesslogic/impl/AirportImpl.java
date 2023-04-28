package businesslogic.impl;

import businesslogic.api.airport.Airport;
import datarecords.AirportData;

public class AirportImpl implements Airport {
    private final AirportData airportData;

    public AirportImpl(String id, String name, String country) {
        this(new AirportData(id, name, country));
    }

    public AirportImpl(AirportData airportData) {
        this.airportData = airportData;
    }

    @Override
    public String getCountry() {
        return airportData.country();
    }

    @Override
    public AirportData getData() {
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

    @Override
    public String toString() {
        return getName();
    }
}
