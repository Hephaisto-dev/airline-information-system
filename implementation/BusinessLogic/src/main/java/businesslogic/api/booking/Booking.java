package businesslogic.api.booking;

import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.StringIdentifiable;
import datarecords.AirplaneData;
import datarecords.BookingData;
import datarecords.CustomerData;

import java.util.ArrayList;

public interface Booking extends StringIdentifiable, PersistantDataContainer<BookingData> {

    String getEmp();
    ArrayList<CustomerData> getCustomersOnBooking();
}
