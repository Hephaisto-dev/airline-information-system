package gui;

import businesslogic.api.customer.Customer;
import businesslogic.api.manager.CustomerManager;
import datarecords.CustomerData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * FXML Customer Controller class.
 * The controller class contains GUI-logic (no business logic!). It reacts on
 * GUI events like button clicks. It triggers the BusinessLogic layer
 * to do the real work. Furthermore the controller will trigger navigation
 * and update the GUI.
 *
 * @author Informatics Fontys Venlo
 */
public class CustomerController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final CustomerManager customerManager;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField dob;
    @FXML
    private Button saveButton;
    @FXML
    private Button toSecondaryButton;
    @FXML
    private Label result;

    public CustomerController(Supplier<SceneManager> sceneManagerSupplier, CustomerManager customerManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.customerManager = customerManager;
    }

    @FXML
    private void toSecondary() {
        Consumer<SecondaryController> consumer
                = (c) -> c.setPreviousView("Customer");
        sceneManagerSupplier.get().changeScene("secondary", consumer);
    }

    @FXML
    private void storeCustomer() {

        CustomerData customerData = new CustomerData(0, firstName.getText(), lastName.getText(),
                LocalDate.parse(dob.getText()));

        Customer addedCustomer = customerManager.add(new Customer(customerData));

        result.setText("Customer added: " + addedCustomer.getData().toString());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
