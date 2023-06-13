package businesslogic.api.manager;

import businesslogic.api.route.Route;
import businesslogic.api.route.RouteFactory;
import businesslogic.impl.ManagerImpl;
import datarecords.RouteData;
import persistence.api.RouteStorageService;

public class RouteManager extends ManagerImpl<Route, RouteData> {

    public RouteManager(RouteStorageService storageService) {
        super(storageService);
    }

    @Override
    protected Route createPersistantDataContainer(RouteData data) {
        return RouteFactory.createRoute(data);
    }
}
