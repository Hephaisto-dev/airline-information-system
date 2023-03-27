package businesslogic.api.manager;

import businesslogic.api.flight.Flight;
import businesslogic.implementation.ManagerImpl;
import datarecords.FlightData;
import persistence.FlightStorageService;

public class FlightManager extends ManagerImpl<Flight, FlightData> {
    public FlightManager(FlightStorageService storageService) {
        super(storageService);
    }
}
