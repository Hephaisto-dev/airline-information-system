package businesslogic.api.customer;

import businesslogic.impl.CustomerImpl;
import datarecords.CustomerData;

import java.time.LocalDate;


public interface CustomerFactory {

    static Customer createCustomer(String id, String firstName, String lastName, LocalDate dob, String email) {
        return new CustomerImpl(id, firstName, lastName, dob, email);
    }

    static Customer createCustomer(CustomerData customerData) {
        return new CustomerImpl(customerData);
    }
}
