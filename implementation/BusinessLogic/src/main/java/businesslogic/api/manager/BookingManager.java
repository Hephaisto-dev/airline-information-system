package businesslogic.api.manager;

import businesslogic.api.booking.Booking;
import businesslogic.implementation.ManagerImpl;
import datarecords.BookingData;
import persistence.api.BookingStorageService;
import persistence.api.AirportStorageService;
import persistence.api.BookingStorageService;

public class BookingManager extends ManagerImpl<Booking, BookingData> {
    public BookingManager(BookingStorageService storageService) {
        super(storageService);
    }

}
