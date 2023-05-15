package businesslogic.api.customer;

import datarecords.CustomerData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerFactoryTest {

    @Test
    void createCustomerWithParameters() {
        Customer customer = CustomerFactory.createCustomer("id", "name", "address", LocalDate.now(), "email");
        assertThat(customer.getId()).isEqualTo("id");
    }

    @Test
    void testCreateCustomer() {
        CustomerData customerData = new CustomerData("id", "name", "address", LocalDate.now(), "email");
        Customer customer = CustomerFactory.createCustomer(customerData);
        assertThat(customer.getData()).isEqualTo(customerData);
    }
}