package businesslogic.api.manager;

import businesslogic.api.route.Route;
import businesslogic.implementation.ManagerImpl;
import datarecords.RouteData;
import persistence.impl.RouteStorageService;

public class RouteManager extends ManagerImpl<Route, RouteData> {

    public RouteManager(RouteStorageService storageService) {
        super(storageService);
    }


    public Route searchRoute(String searchRoute) {
        return getAll().stream()
                .filter(route -> route.getId().contains(searchRoute))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected Route createPersistantDataContainer(RouteData data) {
        return null;
    }
}
