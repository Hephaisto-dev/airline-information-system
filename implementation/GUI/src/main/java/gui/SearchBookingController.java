package gui;

import businesslogic.api.booking.Booking;
import businesslogic.api.manager.BookingManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class SearchBookingController implements Initializable {
    private final BookingManager bookingManager;
    @FXML
    private ListView<Booking> bookingListView;
    private FilteredList<Booking> filteredBookingIds;

    @FXML
    private TextField searchField;

    @FXML
    private Button cancelButton;
    private final Supplier<SceneManager> sceneManagerSupplier;


    public SearchBookingController(Supplier<SceneManager> sceneManagerSupplier,BookingManager bookingManager) {
        this.bookingManager = bookingManager;
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    public void onSearch() {
        String lowerCase = searchField.getText().toLowerCase();
        filteredBookingIds.setPredicate(bookingId -> bookingId.getId().toLowerCase().contains(lowerCase) ||
                bookingId.getCustomersOnBooking().stream().anyMatch(customer ->
                        customer.firstName().toLowerCase().contains(lowerCase) ||
                                customer.lastName().toLowerCase().contains(lowerCase) ||
                                customer.email().toLowerCase().contains(lowerCase)) ||
                bookingId.getEmp().toLowerCase().contains(lowerCase));
    }

    public void onCancel() {
        ObservableList<Booking> selectedItems = bookingListView.getSelectionModel().getSelectedItems();
        boolean success = false;
        for (Booking selectedItem : selectedItems) {
            success = selectedItem.cancel() || success;
        }
        if (success) {
            updateBookingList();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateBookingList();
    }

    private void updateBookingList() {
        filteredBookingIds = new FilteredList<>(FXCollections.observableArrayList(bookingManager.getAll()));
        bookingListView.setItems(filteredBookingIds);
    }
}
