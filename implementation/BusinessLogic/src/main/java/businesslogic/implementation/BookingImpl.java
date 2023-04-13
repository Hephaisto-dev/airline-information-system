package businesslogic.implementation;

import businesslogic.api.booking.Booking;
import datarecords.BookingData;
import datarecords.CustomerData;
import datarecords.FlightData;
import persistence.BookingStorageServiceImpl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingImpl implements Booking {
    private final BookingData bookingData;
    private BookingStorageServiceImpl bookingStorageService;

    public BookingImpl(String id, String empId, FlightData flight, ArrayList<String> Tickets, LocalDateTime bookingDate, ArrayList<String> extras, ArrayList<CustomerData>customerOnBooking) {

        this(new BookingData(id, empId, flight, Tickets, bookingDate, extras, customerOnBooking));
    }

    public BookingImpl(BookingData bookingData) {
        this.bookingData = bookingData;
    }

    @Override
    public String getEmp() {
        return bookingData.empId();
    }

    @Override
    public List<CustomerData> getCustomersOnBooking() {
        return bookingData.customerInBooking();
    }

    @Override
    public boolean cancel() {

        return bookingStorageService.cancelBooking(getId());

    }

    @Override

    public String getId() {
        return bookingData.id();
    }

    @Override
    public BookingData getData() {
        return bookingData;
    }
}
