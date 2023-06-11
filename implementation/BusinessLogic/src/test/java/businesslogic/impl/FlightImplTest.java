package businesslogic.impl;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.airplane.Airplane;
import businesslogic.api.flight.Flight;
import businesslogic.api.manager.AirplaneManager;
import businesslogic.api.manager.FlightManager;
import datarecords.FlightData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class FlightImplTest {

    @Mock
    private AirplaneManager mockAirplaneManager;

    @Mock
    private BusinessLogicAPI businessLogicAPI;

    private static MockedStatic<BusinessLogicFactory> businessLogicFactoryMockedStatic;

    private final FlightData   flightData = new FlightData("flightId", LocalDateTime.now(), LocalDateTime.now().plusHours(1),
            Duration.ofHours(1), "airplaneId", "departureAirportId", "arrivalAirportId");
    private final Flight flight = new FlightImpl(flightData);

    @BeforeAll
    static void setupStatic() {
        businessLogicFactoryMockedStatic = Mockito.mockStatic(BusinessLogicFactory.class);
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize mocks
        businessLogicFactoryMockedStatic.when(BusinessLogicFactory::getImplementation).thenReturn(businessLogicAPI);
        when(businessLogicAPI.getAirplaneManager()).thenReturn(mockAirplaneManager);
    }
    @AfterAll
    static void closeStatic(){
        businessLogicFactoryMockedStatic.close();
    }
    @Test
    void getId() {
        String expectedId = "flightId";

        String actualId = flight.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    void getFlightDuration() {
        assertEquals(flight.getFlightDuration(), flightData.flightDuration());
    }

    @Test
    void getAirplane() {
        Airplane mocked = mock(Airplane.class);

        // Act
        when(mockAirplaneManager.getById("airplaneId")).thenReturn(mocked);

        // Assert
        Assertions.assertThat(flight.getAirplane()).isEqualTo(mocked);

    }

    @Test
    void getETD() {

        assertEquals(flight.getETD(), flightData.etdDateTime());
    }

    @Test
    void getETA() {
        assertEquals(flight.getETA(), flightData.etaDateTime());
    }
    @Test
    void testToString() {
        // Arrange
        String expectedToString = "flightId";

        // Act
        String actualToString = flight.toString();

        // Assert
        assertEquals(expectedToString, actualToString);
    }

    @Test
    void delete() {
        FlightManager flightManagerMock = mock(FlightManager.class);
        when(flightManagerMock.remove(flight)).thenReturn(true);

        when(businessLogicAPI.getFlightManager()).thenReturn(flightManagerMock);

        boolean result = flight.delete();

        verify(flightManagerMock).remove(flight);

        assertTrue(result);
    }
}
