package gui;

import businesslogic.api.common.Identifiable;
import businesslogic.api.manager.BookingManager;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchBookingController implements Initializable {
    private final BookingManager bookingManager;
    @FXML
    private ListView<String> bookingListView;
    private FilteredList<String> filteredBookingIds;

    @FXML
    private TextField searchField;

    @FXML
    private Button cancelButton;

    public SearchBookingController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void onSearch() {
        filteredBookingIds.setPredicate(bookingId -> bookingId.toLowerCase().contains(searchField.getText().toLowerCase()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> bookingIds = new ArrayList<>(bookingManager.getAll().stream().map(Identifiable::getId).toList());
        filteredBookingIds = new FilteredList<>(FXCollections.observableList(bookingIds));
        bookingListView.setItems(filteredBookingIds);
    }
}
