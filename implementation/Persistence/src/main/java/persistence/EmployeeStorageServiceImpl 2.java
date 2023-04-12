package persistence;

import datarecords.EmployeeData;

public class EmployeeStorageServiceImpl implements EmployeeStorageService {
    @Override
    public EmployeeData add(EmployeeData data) {
        return new EmployeeData(data.id(), data.firstName(), data.lastName(), data.email(), data.phoneNumber(),
                data.employeeTypeId(), data.dob());
    }
}
