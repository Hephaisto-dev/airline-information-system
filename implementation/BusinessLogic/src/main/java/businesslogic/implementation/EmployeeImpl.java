package businesslogic.implementation;

import businesslogic.api.employee.Employee;
import businesslogic.api.employee.EmployeeType;
import datarecords.EmployeeData;

import java.time.LocalDate;

public class EmployeeImpl implements Employee {
    private final EmployeeData employeeData;

    public EmployeeImpl(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    @Override
    public String getName() {
        return employeeData.firstName() + " " + employeeData.lastName();
    }

    @Override
    public String getFirstName() {
        return employeeData.firstName();
    }

    @Override
    public String getLastName() {
        return employeeData.lastName();
    }

    @Override
    public LocalDate getDob() {
        return employeeData.dob();
    }

    @Override
    public String getEmail() {
        return employeeData.email();
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.fromId(employeeData.employeeTypeId());
    }

    @Override
    public String getPhoneNumber() {
        return employeeData.phoneNumber();
    }

    @Override
    public String getId() {
        return employeeData.id();
    }

    @Override
    public EmployeeData getData() {
        return employeeData;
    }
}
