package gui;

import businesslogic.api.customer.Customer;
import businesslogic.api.manager.CustomerManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCustomerController implements Initializable {
    private final CustomerManager customerManager;
    @FXML
    private ListView<Customer> customerListView;
    private FilteredList<Customer> filteredCustomers;

    @FXML
    private TextField searchField;

    public DeleteCustomerController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void onSearch() {
        String lowerCase = searchField.getText().toLowerCase();
        filteredCustomers.setPredicate(customer ->
                customer.getId().toLowerCase().contains(lowerCase) ||
                        customer.getLastName().toLowerCase().contains(lowerCase) ||
                        customer.getEmail().toLowerCase().contains(lowerCase) ||
                        customer.getDob().toString().toLowerCase().contains(lowerCase) ||
                        customer.getFirstName().toLowerCase().contains(lowerCase));
    }

    public void onDelete() {
        ObservableList<Customer> selectedItems = customerListView.getSelectionModel().getSelectedItems();
        boolean success = false;
        for (Customer selectedItem : selectedItems) {
            success = selectedItem.delete() || success;
        }
        if (success) {
            updateCustomersList();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCustomersList();
    }

    private void updateCustomersList() {
        filteredCustomers = new FilteredList<>(FXCollections.observableArrayList(customerManager.getAll()));
        customerListView.setItems(filteredCustomers);
        customerListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Customer customer, boolean b) {
                super.updateItem(customer, b);
                if (customer != null) {
                    setText(customer.getName());
                } else {
                    setText("");
                }
            }
        });
    }
}
