package businesslogic.api.manager;

import businesslogic.implementation.ManagerImpl;
import datarecords.AirportData;
import persistence.AirportStorageService;

public class AirportManager extends ManagerImpl<AirportData> {
    public AirportManager(AirportStorageService storageService) {
        super(storageService);
    }
}
