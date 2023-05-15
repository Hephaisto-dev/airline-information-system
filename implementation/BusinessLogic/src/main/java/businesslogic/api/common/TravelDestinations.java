package businesslogic.api.common;

import businesslogic.api.airport.Airport;
import datarecords.FlightData;

public interface TravelDestinations extends PersistantDataContainer<FlightData> {

    Airport getDeparture();

    Airport getArrival();
}
