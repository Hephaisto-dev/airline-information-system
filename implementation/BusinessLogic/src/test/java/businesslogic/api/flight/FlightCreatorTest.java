package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.api.manager.FlightManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

class FlightCreatorTest {
    @Mock
    private FlightManager flightManager;

    private FlightCreator flightCreator;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        flightCreator = new FlightCreator(flightManager);
    }


    @Test
    void flightDepartureError() {
        Airport departPort = null;
        Airport arrivePort = mock(Airport.class);
        LocalDateTime departLDT = LocalDateTime.now().plusHours(1);
        LocalDateTime arriveLDT = LocalDateTime.now().plusHours(2);
        Airplane plane = mock(Airplane.class);

        String result = flightCreator.createFlight(departPort, arrivePort, departLDT.toString(), arriveLDT.toString(), plane);

        assertThat(result).contains("Departure Airport does not exist");
        verifyNoInteractions(flightManager);
    }

    @Test
    void flightArrivalError() {
        Airport departPort = mock(Airport.class);
        Airport arrivePort = null;
        LocalDateTime departLDT = LocalDateTime.now().plusHours(1);
        LocalDateTime arriveLDT = LocalDateTime.now().plusHours(2);
        Airplane plane = mock(Airplane.class);

        String result = flightCreator.createFlight(departPort, arrivePort, departLDT.toString(), arriveLDT.toString(), plane);

        assertThat(result).contains("Arrival Airport does not exist");
        verifyNoInteractions(flightManager);
    }

    @Test
    void flightDepartureTimeError() {
        Airport departPort = mock(Airport.class);
        Airport arrivePort = mock(Airport.class);
        LocalDateTime departLDT = LocalDateTime.now().minusHours(3);
        LocalDateTime arriveLDT = LocalDateTime.now().plusHours(2);
        Airplane plane = mock(Airplane.class);

        String result = flightCreator.createFlight(departPort, arrivePort, departLDT.toString(), arriveLDT.toString(), plane);

        assertThat(result).contains("Ensure that the flight times aren't in the past");
        verifyNoInteractions(flightManager);
    }

    @Test
    void flightArrivalTimeError() {
        Airport departPort = mock(Airport.class);
        Airport arrivePort = mock(Airport.class);
        LocalDateTime departLDT = LocalDateTime.now().plusHours(1);
        LocalDateTime arriveLDT = LocalDateTime.now();
        Airplane plane = mock(Airplane.class);

        String result = flightCreator.createFlight(departPort, arrivePort, departLDT.toString(), arriveLDT.toString(), plane);

        assertThat(result).contains("Time of departure must be before time of arrival");
        verifyNoInteractions(flightManager);
    }

    @Test
    void flightTimeOrderError() {
        Airport departPort = mock(Airport.class);
        Airport arrivePort = mock(Airport.class);
        LocalDateTime departLDT = LocalDateTime.now().plusHours(2);
        LocalDateTime arriveLDT = LocalDateTime.now().plusHours(1);
        Airplane plane = mock(Airplane.class);

        String result = flightCreator.createFlight(departPort, arrivePort, departLDT.toString(), arriveLDT.toString(), plane);

        assertThat(result).contains("Time of departure must be before time of arrival");
        verifyNoInteractions(flightManager);
    }

    @Test
    void flightPastTimeError() {
        Airport departPort = mock(Airport.class);
        Airport arrivePort = mock(Airport.class);
        LocalDateTime departLDT = LocalDateTime.now().minusHours(1);
        LocalDateTime arriveLDT = LocalDateTime.now().plusHours(1);
        Airplane plane = mock(Airplane.class);

        String result = flightCreator.createFlight(departPort, arrivePort, departLDT.toString(), arriveLDT.toString(), plane);

        assertThat(result).contains("Ensure that the flight times aren't in the past");
        verifyNoInteractions(flightManager);
    }

    @Test
    void flightPlaneError() {
        Airport departPort = mock(Airport.class);
        Airport arrivePort = mock(Airport.class);
        LocalDateTime departLDT = LocalDateTime.now().plusHours(1);
        LocalDateTime arriveLDT = LocalDateTime.now().plusHours(2);
        Airplane plane = null;

        String result = flightCreator.createFlight(departPort, arrivePort, departLDT.toString(), arriveLDT.toString(), plane);

        assertThat(result).contains("No plane was provided");
        verifyNoInteractions(flightManager);
    }

}
