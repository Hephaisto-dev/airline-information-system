package businesslogic.api.customer;

import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import datarecords.CustomerData;

import java.time.LocalDate;

public interface Customer extends Nameable, PersistantDataContainer<CustomerData> {
    String getId();

    String getFirstName();

    String getLastName();

    LocalDate getDob();

}
