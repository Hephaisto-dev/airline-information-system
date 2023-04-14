package businesslogic.api.manager;

import businesslogic.api.customer.Customer;
import businesslogic.api.customer.CustomerFactory;
import businesslogic.implementation.ManagerImpl;
import datarecords.CustomerData;
import persistence.api.CustomerStorageService;

/**
 * Manages customers in the business logic.
 * Linking pin between GUI and persistence. Connected to customerStorageService
 * in order to retrieve customers and to persist changes.
 *
 * @author Informatics Fontys Venlo
 */
public class CustomerManager extends ManagerImpl<Customer, CustomerData> {
    public CustomerManager(CustomerStorageService storageService) {
        super(storageService);
    }

    @Override
    protected Customer createPersistantDataContainer(CustomerData data) {
        return CustomerFactory.createCustomer(data);
    }
}
