package businesslogic.api.booking;

import businesslogic.api.customer.CustomerCreator;
import businesslogic.api.customer.TicketCreator;
import businesslogic.api.manager.BookingManager;
import businesslogic.api.manager.CustomerManager;
import datarecords.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingCreator {
    private final BookingManager bookingManager;
    private TicketCreator ticketCreator;
    private CustomerCreator customerCreator;


    public BookingCreator(BookingManager manager) {
        this.bookingManager = manager;

    }

    // Change signature according to record
    public String createBooking(String id, EmployeeData employeeData, FlightData flight, List<TicketData> Tickets, LocalDate bookingDate, List<String> extras, List<String> customersOnBooking, CustomerData mainCustomer) {

// TODO SILL SOME RESTRICTIONS MISSING BECAUSE OF NOT IMPLEMENTED CLASSES

        boolean errors = false;


        StringBuilder stringBuilder = new StringBuilder();


        if (id == null || employeeData == null || flight == null || Tickets == null || bookingDate == null || customersOnBooking == null)//Extras can be null
        {
            errors = true;
            stringBuilder.append("All fields must be filled in!(except extraIds)\n");
        }


        if (customersOnBooking != null && (long) customersOnBooking.size() == 0) {


            errors = true;
            stringBuilder.append("a booking must countain at least 1 person!\n");
        }

        if (Tickets != null && Tickets.size() == 0) {

            errors = true;
            stringBuilder.append("a error happend while generating ticketIds!\n");
        }


        if (!errors) {
            try {

                String customerId = null;//todo make this a code ASK TEAM
                Booking booking = BookingFactory.createBooking(new BookingData(id, employeeData.id(), new ArrayList<>(), bookingDate, extras, customerId));
                bookingManager.add(booking);
                //todo ticketCreator.createTicket(,);
                //todo customerCreator.createCustomer();
            } catch (Exception e) {
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "+If the issue persists, contact the IT department";
            }
            return "Booking was successfully created";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
