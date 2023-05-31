package businesslogic.api.booking;


import businesslogic.api.common.Deleteable;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.customer.Customer;
import businesslogic.api.employee.Employee;
import datarecords.BookingData;

import java.util.List;

public interface Booking extends PersistantDataContainer<BookingData>, Deleteable {
    /**
     * Get the {@link Employee employee} who created the booking
     *
     * @return a copy of the {@link Employee employee} who created the booking
     */
    Employee getEmployee();

    /**
     * Get all {@link Customer customers} on the booking
     *
     * @return an immutable list of all {@link Customer customers} on the booking
     */
    List<Customer> getCustomersOnBooking();
}
