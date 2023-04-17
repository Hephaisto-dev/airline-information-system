package businesslogic.api.employee;

import businesslogic.impl.EmployeeImpl;
import datarecords.EmployeeData;

public interface EmployeeFactory {
    static Employee createEmployee(EmployeeData employeeData) {
        return new EmployeeImpl(employeeData);
    }
}
