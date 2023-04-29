package businesslogic.api.customer;

import businesslogic.api.manager.CustomerManager;

public class CustomerCreator {
    private final CustomerManager customerManager;

    public CustomerCreator(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public Customer createCustomer(String firstName, String lastName, String email) {
        return null;
    }
}
