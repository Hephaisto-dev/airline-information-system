package businesslogic.api.manager;

import static org.junit.jupiter.api.Assertions.*;
import datarecords.FlightData;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class FlightManagerTest {
    @Test
    void createPersistantDataContainer() {
        FlightManager flightManager = new FlightManager(null);
        FlightData flightData = new FlightData("flightId", LocalDateTime.now(), LocalDateTime.now().plusHours(1), Duration.ofHours(1), "airplaneId", "departureAirportId", "arrivalAirportId");
        assertEquals(flightManager.createPersistantDataContainer(flightData).getData(), flightData);
    }
}
