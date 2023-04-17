package persistence.api;

import datarecords.BookingData;
import datarecords.CustomerData;

import java.util.List;

public interface BookingStorageService extends StorageService<BookingData> {

    List<CustomerData> getCustomersOnBooking(String bookingId);

}
