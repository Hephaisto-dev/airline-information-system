package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.function.Supplier;

public class MainController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    @FXML
    private Button createAirportButton;

    @FXML
    private Button createBookingButton;

    @FXML
    private Button createFlightButton;

    @FXML
    private Button createTicketButton;

    @FXML
    private Button customerButton;

    @FXML
    private Button searchBookingButton;

    @FXML
    private Button searchFlightButton;

    public MainController(Supplier<SceneManager> sms) {
        sceneManagerSupplier = sms;
    }

    @FXML
    private void goAirportMenu() throws IOException {
        sceneManagerSupplier.get().changeScene("createAirportView");
    }
    private void goBookingMenu() throws IOException{
        sceneManagerSupplier.get().changeScene("createBookingView");
    }
    private void goFlightMenu() throws IOException{
        sceneManagerSupplier.get().changeScene("createFlightView");
    }
    private void goTicketMenu() throws IOException{
        sceneManagerSupplier.get().changeScene("createTicketView");
    }
    private void goCustomerMenu() throws IOException{
        sceneManagerSupplier.get().changeScene("customerView");
    }
    private void goSearchBookingMenu() throws IOException{
        sceneManagerSupplier.get().changeScene("searchBookingView");
    }
    private void goSearchFlightMenu() throws IOException{
        sceneManagerSupplier.get().changeScene("searchFlightView");
    }

    public void CreateAirport(){
        try{
            goAirportMenu();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void CreateBooking(){
        try{
            goBookingMenu();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void CreateFlight(){
        try{
            goFlightMenu();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void CreateTicket(){
        try{
            goTicketMenu();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void Customer(){
        try{
            goCustomerMenu();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void SearchBooking(){
        try{
            goSearchBookingMenu();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void SearchFlight(){
        try{
            goSearchFlightMenu();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void initialize(){
        createAirportButton.setOnMouseClicked(mouseEvent -> {
            try{
                goAirportMenu();
            }catch (IOException e ){
                e.printStackTrace();
            }
        });

        createBookingButton.setOnMouseClicked(mouseEvent -> {
            try {
                goBookingMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        createFlightButton.setOnMouseClicked(mouseEvent -> {
            try{
                goFlightMenu();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        createTicketButton.setOnMouseClicked(mouseEvent -> {
            try{
                goTicketMenu();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        customerButton.setOnMouseClicked(mouseEvent -> {
            try{
                goCustomerMenu();
            }catch(IOException e){
                e.printStackTrace();
            }
        });
        searchBookingButton.setOnMouseClicked(mouseEvent -> {
            try{
                goSearchBookingMenu();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        searchFlightButton.setOnMouseClicked(mouseEvent -> {
            try{
                goSearchFlightMenu();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

}
