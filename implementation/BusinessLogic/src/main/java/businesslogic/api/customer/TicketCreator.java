package businesslogic.api.customer;

import businesslogic.api.airplane.Seat;
import businesslogic.api.airplane.SeatImpl;
import businesslogic.api.flight.Flight;

import java.util.ArrayList;
import java.util.List;

public class TicketCreator {

    private List errorList = new ArrayList();
    private boolean errorFound = false;

    public String createTicket(Flight flight, String row, String column, String customer){
        return ticketCheck(flight, row, column, customer, errorList);
    }
    private String ticketCheck(Flight fly, String CHAR, String NUM, String cus, List list){
        char letter = 'A';
        int number = 0;
        Seat sit;
        //checking, if the flight was selected
        if(fly == null){
            error(list, "Please select one of the flights");
        }
        //checking the letter information
        if(CHAR != null){
            if(CHAR.length() > 1 || CHAR.length() < 1){
                error(list, "In the column field just add one capital letter of the English Alphabet");
            }else{
                letter = CHAR.charAt(0);
                if(Character.valueOf(letter)<'A' || Character.valueOf(letter)>'Z'){
                    error(list, "The letter in the column field must be from the English Alphabet");
                }
            }
        }else{
            error(list, "Please fill in the column field");
        }
        //Checking the number information
        if(NUM != null){
            try {
                number = Integer.getInteger(NUM);
            }catch(Exception e){
                e.printStackTrace();//to make errormessages more precise
                error(list, "Row must be a number without decimal point");
            }
        }else{
            error(list, "Please fill in the row field");
        }
        //Checking, if there's a customer
        if(cus == null){
            error(list, "Please add a customer name");
        }
        //Booking the Seat
        if(!errorFound){
            if(number > fly.getAirplane().getLength()){
                error(list, "The selected plane has a length of " + fly.getAirplane().getLength()
                        + ", you asked for " + number);
            }else{
                String a = fly.bookSeat(number, letter);
                if(!a.contains("successfully")){
                    error(list, a);
                }
            }
        }
        //returning the end result
        if(!errorFound){
            return "Ticket booked successfully";
        }
        return getErrors(list);
    }
    public void setErrorStatus(boolean status){
        errorFound = status;
    }
    private void error(List listForErrors, String errorMessage){
        errorFound = true;
        listForErrors.add(errorMessage);
    }
    private String getErrors(List<String> list){
        StringBuilder answer = new StringBuilder();
        for(String mistake: list){
            answer.append(mistake);
        }
        return answer.toString();
    }
}
