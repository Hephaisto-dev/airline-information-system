package businesslogic.api.manager;

import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.impl.ManagerImpl;
import datarecords.AirportData;
import persistence.api.AirportStorageService;

public class AirportManager extends ManagerImpl<Airport, AirportData> {
    public AirportManager(AirportStorageService storageService) {
        super(storageService);
    }


    @Override
    protected Airport createPersistantDataContainer(AirportData data) {
        return AirportFactory.createAirport(data);
    }

    //SEARCH AIRPORT
//    public Airport searchAirport(String searchedAirport){
//        return getAll().stream()
//                .filter(airport -> airport.getId().contains(searchedAirport))
//                .findFirst()
//                .orElse(null);
//    }
}
