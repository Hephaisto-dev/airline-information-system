package businesslogic.api.customer;

import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.StringIdentifiable;
import datarecords.CustomerData;

import java.time.LocalDate;

public interface CustomerInterface extends StringIdentifiable,Nameable,PersistantDataContainer<CustomerData>{
    String getId();
    String getFirstName();
    String getLastName();
    LocalDate getDob();

}
