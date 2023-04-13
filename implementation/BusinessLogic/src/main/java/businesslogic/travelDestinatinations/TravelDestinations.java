package businesslogic.travelDestinatinations;

import businesslogic.api.airport.Airport;
import businesslogic.api.common.PersistantDataContainer;
import datarecords.FlightData;

public interface TravelDestinations extends PersistantDataContainer<FlightData> {

    Airport getDeparture();
    Airport getArrival();
}
