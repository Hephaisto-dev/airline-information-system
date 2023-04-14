package businesslogic.api.booking;


import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.StringIdentifiable;
import datarecords.AirplaneData;
import datarecords.BookingData;
import datarecords.CustomerData;

import java.util.ArrayList;

import java.util.List;

public interface Booking extends PersistantDataContainer<BookingData> {

    String getEmp();
    List<CustomerData> getCustomersOnBooking();
}
