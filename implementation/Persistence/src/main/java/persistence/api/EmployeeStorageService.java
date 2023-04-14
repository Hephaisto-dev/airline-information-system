package persistence.api;

import datarecords.EmployeeData;
import persistence.StorageService;

public interface EmployeeStorageService extends StorageService<EmployeeData> {
    EmployeeData add(EmployeeData data);
}
