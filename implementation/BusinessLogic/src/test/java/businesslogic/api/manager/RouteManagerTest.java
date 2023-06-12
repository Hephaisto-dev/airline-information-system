package businesslogic.api.manager;

import datarecords.RouteData;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
public class RouteManagerTest {

    @Test
    void createPersistantDataContainer() {
        RouteManager routeManager = new RouteManager(null);
        RouteData routeData = new RouteData("CommonName","id",new HashMap<>(),1000);
        assertEquals(routeManager.createPersistantDataContainer(routeData).getData(),routeData);
    }
}
