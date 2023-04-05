package businesslogic.implementation;

import businesslogic.api.booking.Booking;
import datarecords.BookingData;
import datarecords.CustomerData;
import datarecords.FlightData;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingImpl implements Booking {
    private final BookingData bookingData;

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
    public ArrayList<CustomerData> getCustomersOnBooking() {
        return bookingData.customerInBooking();
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
