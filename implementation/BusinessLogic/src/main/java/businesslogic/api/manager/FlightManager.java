package businesslogic.api.manager;

import businesslogic.implementation.ManagerImpl;
import datarecords.FlightData;
import persistence.FlightStorageService;

public class FlightManager extends ManagerImpl<FlightData, FlightStorageService> {
    public FlightManager(FlightStorageService storageService) {
        super(storageService);
    }
}