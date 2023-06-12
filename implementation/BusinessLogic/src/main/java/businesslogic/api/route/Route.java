package businesslogic.api.route;

import businesslogic.api.common.PersistantDataContainer;
import datarecords.RouteData;

import java.util.Map;

public interface Route extends PersistantDataContainer<RouteData> {

    String getId();

    RouteData getRouteData();

    Map<String,Long> getFlightIdAndTransit();

    int getPrice();
    String getName();
}
