package businesslogic.api.manager;

import businesslogic.implementation.ManagerImpl;
import datarecords.CustomerData;
import persistence.CustomerStorageService;

/**
 * Manages customers in the business logic.
 * Linking pin between GUI and persistence. Connected to customerStorageService
 * in order to retrieve customers and to persist changes.
 *
 * @author Informatics Fontys Venlo
 */
public class CustomerManager extends ManagerImpl<CustomerData, CustomerStorageService> {
    public CustomerManager(CustomerStorageService storageService) {
        super(storageService);
    }
}