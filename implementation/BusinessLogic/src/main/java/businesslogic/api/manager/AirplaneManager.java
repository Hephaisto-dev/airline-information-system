package businesslogic.api.manager;

import businesslogic.implementation.ManagerImpl;
import datarecords.AirplaneData;
import persistence.AirplaneStorageService;

public class AirplaneManager extends ManagerImpl<AirplaneData, AirplaneStorageService> {
    public AirplaneManager(AirplaneStorageService storageService) {
        super(storageService);
    }
}
