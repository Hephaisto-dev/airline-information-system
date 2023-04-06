package businesslogic.api.manager;

import businesslogic.api.flight.Flight;
import businesslogic.implementation.ManagerImpl;
import datarecords.FlightData;
import persistence.FlightStorageService;
import persistence.FlightStorageServiceImpl;

public class FlightManager extends ManagerImpl<Flight, FlightData> {
    FlightStorageServiceImpl flightStorageService = new FlightStorageServiceImpl();

    public FlightManager(FlightStorageService storageService) {

        super(storageService);


    }

    public Flight searchFlight(String searchPhrase) {
        return getAll().stream()
                .filter(flight -> flight.getId().contains(searchPhrase))
                .findFirst()
                .orElse(null);
    }

}
