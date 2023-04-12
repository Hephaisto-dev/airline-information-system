package businesslogic.api.manager;

import businesslogic.api.booking.Booking;
import businesslogic.implementation.ManagerImpl;
import datarecords.BookingData;
import persistence.BookingStorageService;

public class BookingManager extends ManagerImpl<Booking, BookingData> {
    public BookingManager(BookingStorageService storageService) {
        super(storageService);
    }
}
