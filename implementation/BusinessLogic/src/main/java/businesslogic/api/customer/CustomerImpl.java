package businesslogic.api.customer;

import datarecords.CustomerData;

import java.time.LocalDate;
/**
 * Wrapper class that contains CustomerData and Customer Business Logic.
 *
 * @author Informatics Fontys Venlo
 */
public class CustomerImpl implements Customer {

    private final CustomerData customerData;

    public CustomerImpl(CustomerData customerData) {
        this.customerData = customerData;
    }

    @Override
    public CustomerData getData() {
        return customerData;
    }

    // Write Customer Business Logic (methods) here
    // Changes to CustomerData would mean creation of a new CustomerData
    // object and replace the existing object.


    @Override
    public String getId() {
        return customerData.id();
    }

    @Override
    public String getFirstName() {
        return customerData.firstName();
    }

    @Override
    public String getLastName() {
        return customerData.lastName();
    }

    @Override
    public LocalDate getDob() {
        return customerData.dob();
    }

    @Override
    public String getName() {
        return customerData.firstName() + " " + customerData.lastName();
    }
}
