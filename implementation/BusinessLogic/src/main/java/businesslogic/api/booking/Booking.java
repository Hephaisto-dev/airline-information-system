package businesslogic.api.booking;

import businesslogic.api.common.PersistantDataContainer;
import datarecords.BookingData;
import datarecords.CustomerData;

import java.util.List;

public interface Booking extends PersistantDataContainer<BookingData> {

    String getEmp();

    List<CustomerData> getCustomersOnBooking();
}
