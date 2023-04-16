package businesslogic.api.manager;

import businesslogic.api.employee.Employee;
import businesslogic.api.employee.EmployeeFactory;
import businesslogic.implementation.ManagerImpl;
import datarecords.EmployeeData;
import persistence.api.StorageService;

public class EmployeeManager extends ManagerImpl<Employee, EmployeeData> {
    public EmployeeManager(StorageService<EmployeeData> storageService) {
        super(storageService);
    }

    @Override
    protected Employee createPersistantDataContainer(EmployeeData data) {
        return EmployeeFactory.createEmployee(data);
    }
}
