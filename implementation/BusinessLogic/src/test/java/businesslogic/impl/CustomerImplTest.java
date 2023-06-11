package businesslogic.impl;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.customer.Customer;
import businesslogic.api.manager.CustomerManager;
import datarecords.CustomerData;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerImplTest {
    final CustomerData customerData = new CustomerData("id", "firstName", "lastName", LocalDate.MIN, "email");
    final Customer customer = new CustomerImpl(customerData);

    @Test
    void getId() {
        assertEquals(customer.getId(), "id");
    }

    @Test
    void getFirstName() {
        assertEquals(customer.getFirstName(), "firstName");
    }

    @Test
    void getLastName() {
        assertEquals(customer.getLastName(), "lastName");
    }

    @Test
    void getEmail() {
        assertEquals(customer.getEmail(), "email");
    }

    @Test
    void getDob() {
        assertEquals(customer.getDob(), LocalDate.MIN);
    }

    @Test
    void getName() {
        assertEquals(customer.getName(), "firstName lastName");
    }

    @Test
    void getData() {
        assertEquals(customer.getData(), customerData);
    }

    @Test
    void delete() {
        BusinessLogicAPI businessLogicAPI = Mockito.mock(BusinessLogicAPI.class);
        CustomerManager customerManager = Mockito.mock(CustomerManager.class);
        try (MockedStatic<BusinessLogicFactory> businessLogicFactoryMockedStatic = Mockito.mockStatic(BusinessLogicFactory.class)) {
            businessLogicFactoryMockedStatic.when(BusinessLogicFactory::getImplementation).thenReturn(businessLogicAPI);
            Mockito.when(businessLogicAPI.getCustomerManager()).thenReturn(customerManager);
            customer.delete();
            Mockito.verify(customerManager).remove(customer);
        }
    }
}