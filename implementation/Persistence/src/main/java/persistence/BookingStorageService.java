package persistence;

import datarecords.BookingData;

public interface BookingStorageService extends StorageService<BookingData>{
    boolean cancelBooking(String id);
}
