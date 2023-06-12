package businesslogic.impl;

import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.customer.Customer;
import datarecords.CustomerData;

import java.time.LocalDate;

public class CustomerImpl implements Customer {

    private final CustomerData customerData;

    public CustomerImpl(String id, String firstName, String lastName, LocalDate dob, String email) {
        this.customerData = new CustomerData(id, firstName, lastName, dob, email);
    }

    public CustomerImpl(CustomerData customerData) {
        this.customerData = customerData;
    }

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
    public String getEmail() {
        return customerData.email();
    }

    @Override
    public LocalDate getDob() {
        return customerData.dob();
    }

    @Override
    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public CustomerData getData() {
        return customerData;
    }

    @Override
    public boolean delete() {
        return BusinessLogicFactory.getImplementation().getCustomerManager().remove(this);
    }
}
