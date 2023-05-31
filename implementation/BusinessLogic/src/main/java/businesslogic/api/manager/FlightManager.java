package businesslogic.api.manager;

import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
import businesslogic.impl.ManagerImpl;
import datarecords.FlightData;
import persistence.api.FlightStorageService;
import persistence.api.StorageService;
import persistence.api.TicketStorageService;

public class FlightManager extends ManagerImpl<Flight, FlightData> {

    /*public FlightManager(FlightStorageService storageService) {
        super(storageService);
    }*/
    private final StorageService storageService;

    public FlightManager(StorageService storageService) {
        super(storageService);
        this.storageService = storageService;
        forceUpdate();
    }


    public Flight searchFlight(String searchPhrase) {
        return getAll().stream()
                .filter(flight -> flight.getId().contains(searchPhrase))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Flight createPersistantDataContainer(FlightData data) {
        return FlightFactory.createFlight(data);
    }

    public StorageService getStorer(){
        return this.storageService;
    }
}
