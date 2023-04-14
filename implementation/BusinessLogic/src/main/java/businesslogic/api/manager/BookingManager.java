package businesslogic.api.manager;

import businesslogic.api.airport.Airport;
import businesslogic.api.booking.Booking;
import businesslogic.implementation.ManagerImpl;
import datarecords.AirportData;
import datarecords.BookingData;
import persistence.AirportStorageService;
import persistence.BookingStorageService;
import persistence.BookingStorageServiceImpl;

public class BookingManager extends ManagerImpl<Booking, BookingData> {
    private BookingStorageServiceImpl bookingStorageService;
    public BookingManager(BookingStorageService storageService) {
        super(storageService);
    }
    public boolean cancelBooking(String id) {

        return bookingStorageService.remove(id);

    }
}
