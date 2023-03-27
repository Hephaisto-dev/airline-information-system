package businesslogic.api.manager;

import businesslogic.api.airport.Airport;
import businesslogic.implementation.ManagerImpl;
import datarecords.AirportData;
import persistence.AirportStorageService;

public class AirportManager extends ManagerImpl<Airport, AirportData> {
    public AirportManager(AirportStorageService storageService) {
        super(storageService);
    }
}
