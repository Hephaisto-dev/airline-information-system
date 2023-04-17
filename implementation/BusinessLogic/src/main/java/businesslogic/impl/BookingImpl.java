package businesslogic.impl;

import businesslogic.api.booking.Booking;
import businesslogic.api.manager.BookingManager;
import datarecords.BookingData;
import datarecords.CustomerData;
import datarecords.FlightData;

import java.time.LocalDateTime;
import java.util.List;

public class BookingImpl implements Booking {
    private final BookingData bookingData;
    //TODO initialize bookingManager
    private BookingManager bookingManager;

    public BookingImpl(String id, String empId, FlightData flight, List<String> Tickets, LocalDateTime bookingDate, List<String> extras, List<CustomerData> customerOnBooking) {
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

            return bookingManager.remove(this);

    }

    @Override

    public String getId() {
        return bookingData.id();
    }

    @Override
    public BookingData getData() {
        return bookingData;
    }
    public String ToString() {
        String persons = null;
        for (CustomerData c : getCustomersOnBooking()) {
            persons = c.lastName()+" "+ c.email()+" ";
        }
        return "Booking:" + getId() + " people on the booking: " + persons + " created by" + getEmp();
    }
}
