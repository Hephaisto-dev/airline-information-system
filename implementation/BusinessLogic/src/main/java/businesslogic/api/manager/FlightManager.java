package businesslogic.api.manager;

import businesslogic.api.flight.Flight;
import businesslogic.implementation.ManagerImpl;
import datarecords.FlightData;
import persistence.FlightStorageService;

public class FlightManager extends ManagerImpl<Flight, FlightData> {
    public FlightManager(FlightStorageService storageService) {

        super(storageService);


    }

    private Flight searchFlight(String searchPhrase) {
        return getAll().stream()
                .filter(flight -> flight.getId().contains(searchPhrase))
                .findFirst()
                .orElse(null);
    }

}
