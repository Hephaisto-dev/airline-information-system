package businesslogic.api.employee;

import datarecords.EmployeeData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeFactoryTest {

    @Test
    void createEmployee() {
        EmployeeData employeeData = new EmployeeData("id", "firstname", "lastname", "email", "phone", 0, LocalDate.now());
        Employee employee = EmployeeFactory.createEmployee(employeeData);
        assertEquals(employee.getData(), employeeData);
    }
}