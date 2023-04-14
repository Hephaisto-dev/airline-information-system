package businesslogic.api.manager;

import businesslogic.api.booking.Booking;
import businesslogic.implementation.ManagerImpl;
import datarecords.BookingData;
import persistence.api.BookingStorageService;
import persistence.AirportStorageService;
import persistence.BookingStorageService;
import persistence.BookingStorageServiceImpl;

public class BookingManager extends ManagerImpl<Booking, BookingData> {
    private BookingStorageServiceImpl bookingStorageService;
    public BookingManager(BookingStorageService storageService) {
        super(storageService);
    }
    public boolean cancelBooking(String id) {

        return bookingStorageService.cancelBooking(id);

    }
}
