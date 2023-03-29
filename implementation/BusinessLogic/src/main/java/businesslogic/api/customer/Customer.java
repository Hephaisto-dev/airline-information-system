package businesslogic.api.customer;

import businesslogic.api.common.PersistantDataContainer;
import datarecords.CustomerData;

/**
 * Wrapper class that contains CustomerData and Customer Business Logic.
 *
 * @author Informatics Fontys Venlo
 */
public class Customer implements PersistantDataContainer<CustomerData> {

    private CustomerData customerData;

    public Customer(CustomerData customerData) {
        this.customerData = customerData;
    }

    @Override
    public CustomerData getData() {
        return customerData;
    }

    // Write Customer Business Logic (methods) here
    // Changes to CustomerData would mean creation of a new CustomerData
    // object and replace the existing object.


}
