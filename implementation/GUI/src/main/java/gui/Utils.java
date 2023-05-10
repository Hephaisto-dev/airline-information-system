package gui;

import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Utils {
    public static void makeComboBoxSearchable(ComboBox<String> comboBox) {
        comboBox.setEditable(true);
        final FilteredList<String> filteredItems = comboBox.getItems().filtered(item -> item.toLowerCase().contains(comboBox.getEditor().getText().toLowerCase()));
        SortedList<String> sorted = filteredItems.sorted(String::compareToIgnoreCase);
        comboBox.setItems(sorted);
        comboBox.getEditor().textProperty().addListener((observableValue, oldValue, newValue) -> {
            final String selected = comboBox.getSelectionModel().getSelectedItem();
            final TextField editor = comboBox.getEditor();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                    filteredItems.setPredicate(item -> item.toLowerCase().contains(newValue.toLowerCase()));
                    comboBox.setItems(sorted);
                    comboBox.hide();
                    comboBox.show();
                    comboBox.commitValue(); // Force commit value so the gui don't use space to select the first item
                }
            });
        });
    }
}
