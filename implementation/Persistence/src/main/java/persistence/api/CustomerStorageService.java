package persistence.api;

import datarecords.CustomerData;
import persistence.StorageService;

/**
 * Interface that describes all services offered by the CustomerStorageService.
 *
 * @author Informatics Fontys Venlo
 */
public interface CustomerStorageService extends StorageService<CustomerData> {
    CustomerData add(CustomerData customerData);
}
