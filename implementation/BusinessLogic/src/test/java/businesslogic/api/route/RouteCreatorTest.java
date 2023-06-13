package businesslogic.api.route;

import businesslogic.api.manager.FlightManager;
import businesslogic.api.manager.RouteManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteCreatorTest {
    //format of the data
    //what do i need to test
    //run a test with correct data and one with incorrect data and see if the app can pick up on it

    @Mock
    private FlightManager flightManager;
    @Mock
    private RouteManager routeManager;

    private RouteCreator routeCreator;

    Map<String, Long> mapForRoute1 = new HashMap<String,Long>(){{
        put("Flight1", 86400L);
        put("Flight2",86400L);
        put("Flight3", 86400L);
        put("Flight4",0L);
    }};
    HashMap<Integer,String> rawTransits = new HashMap<>(){{
       put(1,"23h");
       put(2,"24h");
    }};
    HashMap<Integer,String> rawTransits1 = new HashMap<>(){{
        put(1,"31d");
        put(2,"28d");
    }};

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        routeCreator = new RouteCreator(routeManager);

    }

    @Test
    void testWithCorrectData() throws Exception {
        String name = "Correct Name For Route";
        HashMap<Integer,String> rawTransitss = new HashMap<>(){{
            put(1,"27d");
            put(2,"24h");
        }};

        String result = routeCreator.createRoute(name, "routeId", mapForRoute1, 100, rawTransits);
    }
    @Test
    void testNameNotNull() throws Exception {
        // Arrange
        String routeName = null;


        // Act
        String result = routeCreator.createRoute(routeName, "routeId", new HashMap<>(), 100, new HashMap<>());

        // Assert
        assertTrue(result.contains("Please enter a name for the Special Route!"));
    }
    @Test
    void testNameLengthAtLeastTenCharacters() throws Exception {
        // Arrange

        String routeName = "ShortName"; // Less than 10 characters

        // Act
        String result = routeCreator.createRoute(routeName, "routeId", new HashMap<>(), 100, new HashMap<>());

        // Assert
        assertTrue(result.contains("The name of the Special Route has to be at least 10 characters long!"));
    }
    @Test
    void testNameDoesNotContainAnySpecialCharacter() throws Exception {
        // Arrange
        String routeNamee = "N@me For Route That Is Incorrect";

        // Act
        String result = routeCreator.createRoute(routeNamee, "routeId", new HashMap<>(), 100, new HashMap<>());

        // Assert
        Assertions.assertThat(result).contains("The name of the Special Route can not contain any special characters!");
    }

    @Test
    void testTransitTimeMinimumDuration() throws Exception {
        // Arrange
        String routeName = "Common Name For This";
        // Act
        boolean errors = false;
        StringBuilder stringBuilder = new StringBuilder();
        String result = routeCreator.createRoute(routeName, "routeId", mapForRoute1, 100, rawTransits);


        // Assert
        Assertions.assertThat(result).contains("The transit time has to be at least 24 hours!");
    }

    @Test
    void testTransitTimeMaximumDuration() throws Exception {
        String routeName = "CommonNameForThis";
        // Act
        boolean errors = false;
        StringBuilder stringBuilder = new StringBuilder();
        String result = routeCreator.createRoute(routeName, "routeId", mapForRoute1, 100, rawTransits1);


        // Assert
        Assertions.assertThat(result).contains("Transit time can not be more than 30 days!");
    }
}
