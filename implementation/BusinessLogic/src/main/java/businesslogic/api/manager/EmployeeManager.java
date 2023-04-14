package businesslogic.api.manager;

import businesslogic.api.employee.Employee;
import businesslogic.implementation.ManagerImpl;
import datarecords.EmployeeData;
import persistence.api.StorageService;

public class EmployeeManager extends ManagerImpl<Employee, EmployeeData> {
    public EmployeeManager(StorageService<EmployeeData> storageService) {
        super(storageService);
    }
}
