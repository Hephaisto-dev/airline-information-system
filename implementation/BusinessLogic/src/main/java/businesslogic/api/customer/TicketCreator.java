package businesslogic.api.customer;

import businesslogic.api.airplane.Seat;
import businesslogic.api.flight.Flight;
import datarecords.TicketData;
import java.util.ArrayList;
import java.util.List;
import persistence.api.PersistenceAPI;
import persistence.api.TicketStorageService;
import persistence.impl.PersistenceAPIImpl;

public class TicketCreator {

    private final List errorList = new ArrayList();
    private boolean errorFound = false;

    public String createTicket(Flight flight, String row, String column, String customer) {
        return ticketCheck(flight, row, column, customer, errorList);
    }

    private String ticketCheck(Flight fly, String CHAR, String NUM, String cus, List list) {
        char letter = 'A';
        int number = 0;
        Seat sit;
        //checking, if the flight was selected
        if (fly == null) {
            error(list, "Please select one of the flights");
        }
        //checking the letter information
        if (CHAR == null) {
            error(list, "Please fill in the column field");
        }
        //Checking the number information
        if (NUM != null) {
            try {
                number = Integer.getInteger(NUM);
            } catch (Exception e) {
                e.printStackTrace();//to make errormessages more precise
                error(list, "Row must be a number without decimal point");
            }
        } else {
            error(list, "Please fill in the row field");
        }
        //Checking, if there's a customer
        if (cus == null) {
            error(list, "Please add a customer name");
        }
        //Booking the Seat
        if (!errorFound) {
            if (number > fly.getAirplane().getLength()) {
                error(list, "The selected plane has a length of " + fly.getAirplane().getLength()
                        + ", you asked for " + number);
            } else {
                String a = fly.bookSeat(number, letter);
                if (!a.contains("successfully")) {
                    error(list, a);
                }
            }
        }
        //returning the end result
        if (!errorFound) {
            //TicketStorageService TSS = new TicketStorageServiceImpl();
            //TSS.add(new TicketData(""+NUM + CHAR, fly.getId(), cus, fly.getPrice().getBackendPrice()));
            return "Ticket booked successfully";
        }
        return getErrors(list);
    }

    private String ticketCheck(Flight fly, String CHAR, String NUM, String cus, List list, String discount, String voucher) {
        char letter = 'A';
        int number = 0;
        int discountAmount = 0;
        int voucherAmount = 0;
        Seat sit;
        Price cost = null;
        //checking, if the flight was selected
        if (fly == null) {
            error(list, "Please select one of the flights");
        }
        //checking the letter information
        if (CHAR == null) {
            error(list, "Please fill in the column field");
        }
        //Checking the number information
        if (NUM != null) {
            try {
                number = Integer.getInteger(NUM);
            } catch (Exception e) {
                e.printStackTrace();//to make errormessages more precise
                error(list, "Row must be a number without decimal point");
            }
        } else {
            error(list, "Please fill in the row field");
        }
        //Checking, if there's a customer
        if (cus == null) {
            error(list, "Please add a customer name");
        }
        //voucher
        if(voucher != null){
            try{
                voucherAmount = Integer.valueOf(voucher);
            }catch(NumberFormatException nfe){
                error(list, "Voucher is declared by a non-decimal number (1,2,...)");
            }
        }
        //discount
        if(discount != null){
            try{
                discountAmount = Integer.valueOf(discount);
            }catch(NumberFormatException nfe){
                error(list, "Discount is declared by a non-decimal number (1,2,...)");
            }
        }
        //Booking the Seat
        if (!errorFound) {
            if (number > fly.getAirplane().getLength()) {
                error(list, "The selected plane has a length of " + fly.getAirplane().getLength()
                        + ", you asked for " + number);
            } else {
                String a = fly.bookSeat(number, letter);
                if (!a.contains("successfully")) {
                    error(list, a);
                }else{
                    cost = fly.getPrice();
                    cost.applyVoucher(voucherAmount);
                    cost.applyDiscount(discountAmount);
                }
            }
        }
        //returning the end result
        if (!errorFound) {
            PersistenceAPI persistence = new PersistenceAPIImpl();
            TicketStorageService ticketStorageService = persistence.getTicketStorageService();
            ticketStorageService.add(new TicketData(fly.getId() + NUM + CHAR, fly.getId(), cus, cost.getBackendPrice()));
            return "Ticket booked successfully";
        }
        return getErrors(list);
    }

    public void setErrorStatus(boolean status) {
        errorFound = status;
    }

    private void error(List listForErrors, String errorMessage) {
        errorFound = true;
        listForErrors.add(errorMessage);
    }

    private String getErrors(List<String> list) {
        StringBuilder answer = new StringBuilder();
        for (String mistake : list) {
            answer.append(mistake);
        }
        return answer.toString();
    }
}
