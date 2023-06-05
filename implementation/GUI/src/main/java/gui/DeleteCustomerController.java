package gui;

import businesslogic.api.customer.Customer;
import businesslogic.api.manager.CustomerManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCustomerController implements Initializable {
    private final CustomerManager customerManager;
    @FXML
    public Label result;
    @FXML
    private TableView<Customer> customerTableView;
    private FilteredList<Customer> filteredCustomers;

    @FXML
    private TextField searchField;

    public DeleteCustomerController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @FXML
    private void onSearch() {
        String lowerCase = searchField.getText().toLowerCase();
        filteredCustomers.setPredicate(customer ->
                customer.getId().toLowerCase().contains(lowerCase) ||
                        customer.getLastName().toLowerCase().contains(lowerCase) ||
                        customer.getEmail().toLowerCase().contains(lowerCase) ||
                        customer.getDob().toString().toLowerCase().contains(lowerCase) ||
                        customer.getFirstName().toLowerCase().contains(lowerCase));
    }

    @FXML
    private void onDelete() {
        ObservableList<Customer> selectedItems = customerTableView.getSelectionModel().getSelectedItems();
        boolean success = false;
        for (Customer selectedItem : selectedItems) {
            success = selectedItem.delete() || success;
        }
        if (success) {
            updateCustomersList();
            result.setText("Successfully deleted customer(s)");
        } else {
            result.setText("Failed to delete customer(s)");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCustomersList();
        // Compute a percentage to size the columns based on the table size, 0.01 offset to prevent scrollbars
        double percentage = (1.0 / 4) - 0.01;
        TableColumn<Customer, String> firstName = new TableColumn<>("First name");
        firstName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFirstName()));
        firstName.prefWidthProperty().bind(customerTableView.prefWidthProperty().multiply(percentage));
        customerTableView.getColumns().add(firstName);
        TableColumn<Customer, String> lastName = new TableColumn<>("Last name");
        lastName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getLastName()));
        lastName.prefWidthProperty().bind(customerTableView.prefWidthProperty().multiply(percentage));
        customerTableView.getColumns().add(lastName);
        TableColumn<Customer, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEmail()));
        email.prefWidthProperty().bind(customerTableView.prefWidthProperty().multiply(percentage));
        customerTableView.getColumns().add(email);
        TableColumn<Customer, String> dob = new TableColumn<>("Date of birth");
        dob.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getDob().toString()));
        dob.prefWidthProperty().bind(customerTableView.prefWidthProperty().multiply(percentage));
        customerTableView.getColumns().add(dob);
    }

    private void updateCustomersList() {
        filteredCustomers = new FilteredList<>(FXCollections.observableArrayList(customerManager.getAll()));
        customerTableView.setItems(filteredCustomers);
    }
}
