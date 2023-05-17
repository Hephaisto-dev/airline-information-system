package businesslogic.impl;

import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.booking.Booking;
import businesslogic.api.customer.Customer;
import businesslogic.api.employee.Employee;
import datarecords.BookingData;

import java.util.List;

public class BookingImpl implements Booking {
    private final BookingData bookingData;

    public BookingImpl(BookingData bookingData) {
        this.bookingData = bookingData;
    }

    @Override
    public Employee getEmployee() {
        return BusinessLogicFactory.getImplementation().getEmployeeManager().getById(bookingData.employeeId());
    }

    @Override //Todo uncomment this and make it work again
    public List<Customer> getCustomersOnBooking() {
        return null;//BusinessLogicFactory.getImplementation().getCustomerManager().getAll().stream().filter(customer -> bookingData.customerIds().contains(customer.getId())).toList();
    }

    @Override
    public boolean cancel() {
        return BusinessLogicFactory.getImplementation().getBookingManager().remove(this);
    }

    @Override

    public String getId() {
        return bookingData.id();
    }

    @Override
    public BookingData getData() {
        return bookingData;
    }

    @Override
    public String toString() {
        String persons = null;
        for (Customer c : getCustomersOnBooking()) {
            persons = c.getLastName()+" "+ c.getData().email()+" ";
        }
        return "Booking:" + getId() + " people on the booking: " + persons + " created by" + getEmployee();
    }
}
