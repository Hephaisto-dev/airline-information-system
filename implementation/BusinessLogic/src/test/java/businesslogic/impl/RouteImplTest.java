package businesslogic.impl;

import businesslogic.api.route.Route;
import datarecords.RouteData;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteImplTest {
    private final String nameForRoute1 = "nameForRoute1";
    private final String idForRoute1 = "idForRoute1";
    Map<String, Long> mapForRoute1 = Map.of("Flight1", 100L,"Flight2",200L,"Flight3", 300L,"Flight4",0L);
    private final int priceForRoute1 = 2000;

    @Test
    void testRouteGetId() {
        RouteData routeData = new RouteData(nameForRoute1,idForRoute1, mapForRoute1, priceForRoute1);
        Route route = new RouteImpl(routeData);
        String routeId = route.getId();
        assertEquals(idForRoute1,routeId);
    }

    @Test
    void getFlightIdAndTransit() {
        RouteData routeData = new RouteData(nameForRoute1,idForRoute1, mapForRoute1, priceForRoute1);
        Route route = new RouteImpl(routeData);

        Map<String,Long> idAndTransit = route.getFlightIdAndTransit();

        Map<String, Long> expected = Map.of("Flight1", 100L,"Flight2",200L,"Flight3", 300L,"Flight4",0L);

        assertEquals(expected,idAndTransit);
    }

    @Test
    void getRouteData() {
        RouteData routeData = new RouteData(nameForRoute1,idForRoute1, mapForRoute1, priceForRoute1);
        Route route = new RouteImpl(routeData);
        RouteData result = route.getRouteData();
        assertEquals(routeData, result);
    }

    @Test
    void getData() {
        RouteData routeData = new RouteData(nameForRoute1,idForRoute1, mapForRoute1, priceForRoute1);
        Route route = new RouteImpl(routeData);
        RouteData result = route.getData();
        assertEquals(routeData, result);

    }

    @Test
    void getPrice() {
        RouteData routeData = new RouteData(nameForRoute1,idForRoute1, mapForRoute1, priceForRoute1);
        Route route = new RouteImpl(routeData);
        int price = route.getPrice();
        assertEquals(priceForRoute1,price);
    }

    @Test
    void getName() {
        RouteData routeData = new RouteData(nameForRoute1,idForRoute1, mapForRoute1, priceForRoute1);
        Route route = new RouteImpl(routeData);
        String name = route.getName();
        assertEquals(nameForRoute1,name);
    }

    @Test
    void testToString() {
        RouteData routeData = new RouteData(nameForRoute1,idForRoute1, mapForRoute1, priceForRoute1);
        Route route = new RouteImpl(routeData);
        String result = route.toString();
        assertEquals(idForRoute1, result);
    }
}
