package businesslogic.api.manager;

import datarecords.CustomerData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagerTest {

    @Test
    void createPersistantDataContainer() {
        CustomerManager customerManager = new CustomerManager(null);
        CustomerData customerData = new CustomerData("id", "firstName", "lastName", LocalDate.now(), "email");
        assertEquals(customerManager.createPersistantDataContainer(customerData).getData(), customerData);
    }
}