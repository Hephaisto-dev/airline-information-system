package businesslogic.api.customer;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.Person;
import datarecords.CustomerData;

public interface Customer extends PersistantDataContainer<CustomerData>, Person {
    boolean delete();
}
