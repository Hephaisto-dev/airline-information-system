package businesslogic.api.manager;

import businesslogic.api.booking.Booking;
import businesslogic.api.booking.BookingFactory;
import businesslogic.impl.ManagerImpl;
import datarecords.BookingData;
import persistence.api.BookingStorageService;

public class BookingManager extends ManagerImpl<Booking, BookingData> {
    public BookingManager(BookingStorageService storageService) {
        super(storageService);
    }

    @Override
    protected Booking createPersistantDataContainer(BookingData data) {
        return BookingFactory.createBooking(data);
    }
}
