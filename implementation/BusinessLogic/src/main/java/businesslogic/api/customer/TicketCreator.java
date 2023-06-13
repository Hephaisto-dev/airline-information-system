package businesslogic.api.customer;

import businesslogic.api.flight.Flight;
import datarecords.TicketData;
import persistence.api.PersistenceFactory;
import persistence.api.TicketStorageService;
import persistence.api.exceptions.ConnectionException;
import persistence.api.exceptions.CustomerException;

import java.util.ArrayList;
import java.util.List;

public class TicketCreator {

    private final List<String> errorList = new ArrayList<>();
    private final TicketStorageService TSS;
    private boolean errorFound = false;

    public TicketCreator() {
        TSS = PersistenceFactory.getImplementation().getTicketStorageService();
    }

    public TicketCreator(TicketStorageService ticketStorageService) {
        TSS = ticketStorageService;
    }

    public String createTicket(Flight flight, String row, String column, String customer, String discount, String voucher) {
        errorList.clear();
        return ticketCheck(flight, row, column, customer, errorList, discount, voucher);
    }


    private String ticketCheck(Flight fly, String NUM, String CHAR, String cus, List<String> list, String discount, String voucher) {
        errorFound = false;
        char letter = 'A';
        int number = 0;
        int discountAmount = 0;
        int voucherAmount = 0;
        Price cost = null;
        //checking, if the flight was selected
        if (fly == null) {
            error(list, "Please select one of the flights");
        }
        //checking the letter information
        if (CHAR == null || CHAR.isEmpty()) {
            error(list, "Please fill in the column field");
        } else {
            if (CHAR.length() > 1) {
                error(list, "Please only add a single letter to the column field");
            } else {
                letter = CHAR.charAt(0);
                if (letter < 'A' || letter > 'Z') {
                    error(list, "Please designate the column with a capital letter of the english alphabet");
                }
            }
        }
        //Checking the number information
        if (NUM != null) {
            try {
                //number = Integer.getInteger(NUM);
                number = Integer.parseInt(NUM);
            } catch (NumberFormatException nfe) {
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
        if (voucher != null) {
            try {
                voucherAmount = Integer.parseInt(voucher);
            } catch (NumberFormatException nfe) {
                error(list, "Voucher is declared by a non-decimal number (1,2,...)");
            }
        }
        //discount
        if (discount != null) {
            try {
                discountAmount = Integer.parseInt(discount);
            } catch (NumberFormatException nfe) {
                error(list, "Discount is declared by a non-decimal number (1,2,...)");
            }
        }
        if (!errorFound && fly != null) {
            cost = fly.getPrice();
            if (discount != null) {
                cost.applyDiscount(discountAmount);
            }
            if (voucher != null) {
                cost.applyVoucher(voucherAmount);
            }
        }
        //Booking the Seat
        if (!errorFound && fly != null) {
            if (number > fly.getAirplane().getLength()) {
                error(list, "The selected plane has a length of " + fly.getAirplane().getLength()
                        + ", you asked for " + number);
            } else {
                String a = fly.bookSeat(number, letter);
                if (!a.contains("successfully")) {
                    error(list, a);//TODO: Control/check this one
                }
            }
        }
        //returning the end result
        if (!errorFound && cost != null) {
            try {
                TSS.add(new TicketData(fly.getId() + NUM + CHAR, fly.getId(), cus, cost.getBackendPrice(), NUM + CHAR));
            } catch (CustomerException custi) {
                if (custi.getMessage().contains("Customer_ID not in our Database")) {
                    error(list, "Please ensure validity of customer id (not present in database)");
                }
            } catch (ConnectionException conni) {
                error(list, "You or the server is having connectivity problems");
            } catch (Exception e) {
                e.printStackTrace();
                error(list, "Unhandled exception");
            }
            if (errorFound) {
                return getErrors(list);
            }
            return "Ticket booked successfully";
        }
        return getErrors(list);
    }


    private void error(List<String> listForErrors, String errorMessage) {
        errorFound = true;
        listForErrors.add(errorMessage);
    }

    private String getErrors(List<String> list) {
        StringBuilder answer = new StringBuilder();
        for (String mistake : list) {
            answer.append(mistake);
            answer.append("\n");
        }
        list.clear();
        return answer.toString();
    }
}
