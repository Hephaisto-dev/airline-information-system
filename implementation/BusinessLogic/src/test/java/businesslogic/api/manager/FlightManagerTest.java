package businesslogic.api.manager;

import businesslogic.api.flight.Flight;
import datarecords.FlightData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import persistence.FlightStorageService;
import persistence.FlightStorageServiceImpl;

import java.util.ArrayList;
import java.util.List;

class FlightManagerTest {
    @Test
    void checkFlight(FlightData flightData) {

        FlightData flightData1= new FlightData(flightData.id(), flightData.routeData(), flightData.etdDateTime(), flightData.etaDateTime(), flightData.flightDuration(), flightData.airplane());

        List<FlightData> flightDataList = new ArrayList<>();
        flightDataList.add(flightData1);


        FlightStorageService flightStorageService = new FlightStorageServiceImpl(flightDataList);

        FlightManager flightManager = new FlightManager(flightStorageService);

        Flight result1 = flightManager.searchFlight("ABC");
        Assertions.assertNotNull(result1);

    }
}