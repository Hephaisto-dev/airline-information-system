package gui;

import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Utils {
    public static <T> void makeComboBoxSearchable(ComboBox<T> comboBox) {
        comboBox.setEditable(true);
        final FilteredList<T> filteredItems = comboBox.getItems().filtered(item -> true);
        SortedList<T> sorted = filteredItems.sorted((o1, o2) -> o1.toString().compareToIgnoreCase(o2.toString()));
        comboBox.setItems(sorted);
        comboBox.getEditor().textProperty().addListener((observableValue, oldValue, newValue) -> {

            final T selected = comboBox.getSelectionModel().getSelectedItem();
            final TextField editor = comboBox.getEditor();

            Platform.runLater(() -> {
                if (selected == null || !selected.toString().equals(editor.getText())) {
                    filteredItems.setPredicate(item -> item.toString().toLowerCase().contains(newValue.toLowerCase()));
                    comboBox.setItems(sorted);
                    comboBox.hide();
                    comboBox.show();
                    comboBox.commitValue();
                }
            });
        });
    }
}
