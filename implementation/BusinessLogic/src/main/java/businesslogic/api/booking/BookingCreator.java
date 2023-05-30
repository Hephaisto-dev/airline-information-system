package businesslogic.api.booking;

import businesslogic.api.customer.Customer;
import businesslogic.api.customer.CustomerCreator;
import businesslogic.api.customer.TicketCreator;
import businesslogic.api.flight.Flight;
import businesslogic.api.manager.BookingManager;
import businesslogic.api.manager.CustomerManager;
import datarecords.*;
import businesslogic.api.flight.FlightFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class BookingCreator {
    private final BookingManager bookingManager;
    private TicketCreator ticketCreator;
    private CustomerCreator customerCreator;
    private FlightFactory flightFactory;
    private CustomerManager customerManager;
    private final static String emailRegex = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";



    public BookingCreator(BookingManager manager) {
        this.bookingManager = manager;

    }

    // Change signature according to record
    public String createBooking(String id, String employeeData, FlightData flight, List<TicketData> Tickets, LocalDate bookingDate, List<String> extras, List<CustomerData> customersOnBooking, CustomerData mainCustomer) {


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

//        if (Tickets != null && Tickets.size() == 0) {
//
//            errors = true;
//            stringBuilder.append("a error happend while generating ticketIds!\n");
//        }


        if (!errors) {
            try {

                String customerId = mainCustomer.id();
                Booking booking = BookingFactory.createBooking(new BookingData(id, employeeData, null, bookingDate, extras, customerId,flight.id()));
                Flight flight1 = FlightFactory.createFlight(flight);
                    customerCreator.createCustomer(mainCustomer.firstName(), mainCustomer.lastName(), mainCustomer.dob(),mainCustomer.email());


                bookingManager.add(booking);
                System.out.println("wow a booking has been created");


                for (CustomerData c:customersOnBooking)
                {

                    System.out.println("wow a ticket has been created");
                    ticketCreator.createTicket(flight1,"A","1",c.firstName()+" "+c.lastName(),"","");
                    if(mainCustomer!=c){
                        customerCreator.createCustomer(c.firstName(), c.lastName(), c.dob(),c.email());

                    }

                }
                System.out.println("wow a customer has been created");
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
