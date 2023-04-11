package businesslogic.api.customer;

import businesslogic.implementation.CustomerImpl;
import datarecords.CustomerData;

import java.time.LocalDate;


public interface CustomerFactory {

    static Customer createCustomer(String id, String firstName, String lastName, LocalDate dob, String email) {
        return new CustomerImpl(id, firstName, lastName, dob, email);
    }

    static Customer createCustomer(CustomerData customerData) {
        return new CustomerImpl(customerData);
    }

    static Customer createCustomer(String id) throws CustomerNotFoundException {
        if (true) {
            LocalDate loc = LocalDate.of(2002, 2, 2);
            return new CustomerImpl(id, "NameFirst", "NameSecond", loc, "example@gmail.com");
        } else {
            throw new CustomerNotFoundException();
        }
    }
}
