package businesslogic.api.manager;

import businesslogic.api.route.Route;
import businesslogic.implementation.ManagerImpl;
import datarecords.RouteData;
import persistence.RouteStorageServiceImpl;
import persistence.StorageService;

public class RouteManager extends ManagerImpl<Route, RouteData> {

    RouteStorageServiceImpl routeStorageServiceImpl = new RouteStorageServiceImpl();
    public RouteManager(StorageService<RouteData> storageService) {
        super(storageService);
    }


    public Route searchRoute(String searchRoute) {
        return getAll().stream()
                .filter(route -> route.getId().contains(searchRoute))
                .findFirst()
                .orElse(null);
    }
}
