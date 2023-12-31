package gui;

import businesslogic.api.customer.CustomerCreator;
import businesslogic.api.manager.CustomerManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

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
    private final CustomerCreator customerCreator;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField email;
    @FXML
    private Label result;

    public CreateCustomerController(CustomerManager customerManager) {
        this.customerCreator = new CustomerCreator(customerManager);
    }

    @FXML
    private void storeCustomer() {
        String message = customerCreator.createCustomer(firstName.getText(), lastName.getText(), dob.getValue(), email.getText());
        result.setText(message);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate maxDate = LocalDate.now();
        dob.setDayCellFactory(d ->
                new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isAfter(maxDate));
                    }
                });
    }
}
