package businesslogic.api.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTypeTest {

    @Test
    void fromId() {
        for (EmployeeType employeeType : EmployeeType.values()) {
            assertEquals(employeeType, EmployeeType.fromId(employeeType.getId()));
        }
    }
}