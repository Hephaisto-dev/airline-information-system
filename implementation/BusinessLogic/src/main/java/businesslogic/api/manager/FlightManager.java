package businesslogic.api.manager;

import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
import businesslogic.impl.ManagerImpl;
import datarecords.FlightData;
import persistence.api.FlightStorageService;

public class FlightManager extends ManagerImpl<Flight, FlightData> {

    public FlightManager(FlightStorageService storageService) {
        super(storageService);
    }

    @Override
    protected Flight createPersistantDataContainer(FlightData data) {
        return FlightFactory.createFlight(data);
    }
}
