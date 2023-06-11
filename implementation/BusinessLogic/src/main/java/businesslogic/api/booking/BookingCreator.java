package businesslogic.api.booking;

import businesslogic.api.customer.Customer;
import businesslogic.api.customer.CustomerCreator;
import businesslogic.api.customer.Ticket;
import businesslogic.api.customer.TicketCreator;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
import businesslogic.api.manager.BookingManager;
import businesslogic.api.manager.CustomerManager;
import businesslogic.api.manager.TicketManager;
import datarecords.BookingData;
import datarecords.CustomerData;
import datarecords.FlightData;
import datarecords.TicketData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookingCreator {
    private final BookingManager bookingManager;
    List<String> customerIds = new ArrayList<>();
    private TicketCreator ticketCreator;
    private TicketManager ticketManager;
    private CustomerCreator customerCreator;
    private FlightFactory flightFactory;
    private final CustomerManager customerManager;
    private Collection<String> allCustomer = new ArrayList<>();
    private final Collection<TicketData> tickets = new ArrayList<>();//ticketManager.getStorageService().getAll(); aparently this is not implemented yet



    public BookingCreator(BookingManager manager, TicketManager ticketManager, CustomerManager customerManager) {
        this.bookingManager = manager;
        this.customerManager = customerManager;
        this.customerCreator = new CustomerCreator(customerManager);
        this.ticketCreator = new TicketCreator(ticketManager.getStorageService());
    }


    // Change signature according to record
    public String createBooking(String id, String employeeData, Flight flight, List<TicketData> Tickets, LocalDate bookingDate, List<String> extras, List<Customer> customersOnBooking, Customer mainCustomer) {

        for (Customer c : customerManager.getAll()) {
            allCustomer.add(c.getId());
        }
        for (Customer c : customersOnBooking) {
            customerIds.add("CU_" + c.getEmail());
        }


        boolean errors = false;


        StringBuilder stringBuilder = new StringBuilder();


        if (id == null || employeeData == null || flight == null || bookingDate == null || customersOnBooking == null)//Extras can be null
        {
            errors = true;
            stringBuilder.append("All fields must be filled in!(except extraIds)\n");
        }


        if (customersOnBooking.size() == 0) {


            errors = true;
            stringBuilder.append("a booking must countain at least 1 person!\n");
        }


        if (!errors) {
            try {

                String customerId = mainCustomer.getId();
                Booking booking = BookingFactory.createBooking(new BookingData(id, employeeData, customerIds, bookingDate, extras, customerId, flight.getId()));
                customerCreator.createCustomer(mainCustomer.getFirstName(), mainCustomer.getLastName(), mainCustomer.getDob(), mainCustomer.getEmail());
                bookingManager.add(booking);
                System.out.println("wow a booking has been created");

                int seatNum = ticketsDivider(flight);
                for (Customer c : customersOnBooking) {
                    System.out.println("wow a ticket has been created");


                    String Ticketresult = ticketCreator.createTicket(flight, String.valueOf(seatNum), "B", c.getFirstName() + " " + c.getLastName(), null, null);//discount and voucher not yet implemented and seats algorithm is not yet made
                    if(Ticketresult!="Ticket booked successfully"){
                        errors=true;
                        stringBuilder.append(Ticketresult);
                    }
                    seatNum--;
                    System.out.println(Ticketresult);

                    if (!allCustomer.contains(c.getId())) {//this makes sure the tickets are created for everyone even is the account already exists
                        if (mainCustomer != c) {
                            String Customerresult = customerCreator.createCustomer(c.getFirstName(), c.getLastName(), c.getDob(), c.getEmail());
                            if(Customerresult!="Customer created successfully."){
                                errors=true;
                                stringBuilder.append(Customerresult);
                            }
                        }
                    }
                    //this makes sure the main customer is not added twice


                }
                System.out.println("wow a customer has been created");
            } catch (Exception e) {
                e.printStackTrace();

                return "There seems to be an issue with the database, please try again." + "\n"
                        + "+If the issue persists, contact the IT department";
            }
            return "Booking was successfully created";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }

    private int ticketsDivider(Flight flight) {
        int total = 12;//flight.getAirplane().getSeats();apparently not implemented yet
        for (TicketData t : tickets) {
            if (t.flightId() == flight.getId()) {
                total = total - 1;
            }
        }
        return total;
    }
}

