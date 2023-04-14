package persistence.impl;

import datarecords.EmployeeData;
import persistence.api.EmployeeStorageService;

import javax.sql.DataSource;

public class EmployeeStorageServiceImpl implements EmployeeStorageService {
    private final DataSource dataSource;

    public EmployeeStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public EmployeeData add(EmployeeData data) {
        return new EmployeeData(data.id(), data.firstName(), data.lastName(), data.email(), data.phoneNumber(),
                data.employeeTypeId(), data.dob());
    }
}
