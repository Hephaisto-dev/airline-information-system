package businesslogic.api.manager;

import businesslogic.api.airplane.Airplane;
import businesslogic.implementation.ManagerImpl;
import datarecords.AirplaneData;
import persistence.api.AirplaneStorageService;

public class AirplaneManager extends ManagerImpl<Airplane, AirplaneData> {
    public AirplaneManager(AirplaneStorageService storageService) {
        super(storageService);
    }
}
