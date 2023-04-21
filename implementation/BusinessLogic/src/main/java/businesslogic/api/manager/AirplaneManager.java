package businesslogic.api.manager;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.impl.ManagerImpl;
import datarecords.AirplaneData;
import persistence.api.AirplaneStorageService;

public class AirplaneManager extends ManagerImpl<Airplane, AirplaneData> {
    public AirplaneManager(AirplaneStorageService storageService) {
        super(storageService);
    }

    @Override
    protected Airplane createPersistantDataContainer(AirplaneData data) {
        return AirplaneFactory.createAirplane(data);
    }
}
