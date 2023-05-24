package businesslogic.api.employee;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.Person;
import datarecords.EmployeeData;

public interface Employee extends Person, PersistantDataContainer<EmployeeData> {
    EmployeeType getEmployeeType();

    String getPhoneNumber();
}
