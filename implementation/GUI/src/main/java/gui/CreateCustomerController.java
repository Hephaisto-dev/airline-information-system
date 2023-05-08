package gui;

import businesslogic.api.customer.Customer;
import businesslogic.api.customer.CustomerFactory;
import businesslogic.api.manager.CustomerManager;
import datarecords.CustomerData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
public class CreateCustomerController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final CustomerManager customerManager;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField email;
    @FXML
    private Button saveButton;
    @FXML
    private Label result;

    public CreateCustomerController(Supplier<SceneManager> sceneManagerSupplier, CustomerManager customerManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.customerManager = customerManager;
    }

    @FXML
    private void storeCustomer() {
        CustomerData customerData = new CustomerData("0", firstName.getText(), lastName.getText(),
                dob.getValue(), email.getText());

        Customer addedCustomer = customerManager.add(CustomerFactory.createCustomer(customerData));

        result.setText("Customer added: " + addedCustomer.getData().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate maxDate = LocalDate.now();
        dob.setDayCellFactory(d ->
                new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isAfter(maxDate));
                    }});
    }
}
