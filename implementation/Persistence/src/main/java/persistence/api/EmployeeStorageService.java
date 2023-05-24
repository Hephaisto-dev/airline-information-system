package persistence.api;

import datarecords.EmployeeData;

public interface EmployeeStorageService extends StorageService<EmployeeData> {
    EmployeeData add(EmployeeData data);
}
