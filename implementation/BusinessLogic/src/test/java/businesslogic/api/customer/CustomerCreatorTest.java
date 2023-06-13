package businesslogic.api.customer;

import businesslogic.api.manager.CustomerManager;
import datarecords.CustomerData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import persistence.api.CustomerStorageService;
import persistence.api.exceptions.PersistanceException;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustomerCreatorTest {
    @Mock
    private CustomerStorageService customerStorageService;

    private CustomerCreator customerCreator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerCreator = new CustomerCreator(new CustomerManager(customerStorageService));
    }

    @ParameterizedTest
    @CsvSource({
            "John, Doe, 1990-01-01, johndoe@mail.com, Customer created successfully.",
            "John, Doe, 1990-01-01, johndoe.email.com, Email is not valid,",
            "John, Doe, 3000-01-01, , Email is empty,",
            "John, Doe, , johndoe@mail.com, Date of birth is empty,",
            "John, , 1990-01-01, johndoe@mail.com, Last name is empty,",
            ", Doe, 1990-01-01, johndoe@mail.com, First name is empty,",
    })
    void createCustomer(String firstName, String lastName, LocalDate dob, String email, String result) throws PersistanceException {
        when(customerStorageService.add(Mockito.any(CustomerData.class))).thenAnswer(invocation -> invocation.getArgument(0));
        assertThat(customerCreator.createCustomer(firstName, lastName, dob, email)).containsOnlyOnce(result);
    }

    @Test
    void addCustomerAlreayExists() throws PersistanceException {
        when(customerStorageService.add(Mockito.any(CustomerData.class))).thenReturn(null);
        assertThat(customerCreator.createCustomer("John", "Doe", LocalDate.of(1990, 1, 1),
                "johndoe@mail.com")).containsOnlyOnce("Customer already exists.");
        verify(customerStorageService).add(Mockito.any(CustomerData.class));
    }

    @Test
    void addCustomerPersistanceException() throws PersistanceException {
        when(customerStorageService.add(Mockito.any())).thenThrow(new PersistanceException("Error"));
        assertThat(customerCreator.createCustomer("John", "Doe", LocalDate.of(1990, 1, 1),
                "johndoe@mail.com")).containsOnlyOnce("Error creating customer.");
        verify(customerStorageService).add(Mockito.any(CustomerData.class));
    }
}