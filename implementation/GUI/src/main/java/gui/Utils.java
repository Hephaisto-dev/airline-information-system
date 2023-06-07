package gui;

import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.util.StringConverter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Utils {
    public static <T> void makeComboBoxSearchable(ComboBox<T> comboBox, Function<T, String> toString) {
        comboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(T t) {
                return t == null ? "" : toString.apply(t);
            }

            @Override
            public T fromString(String s) {
                return comboBox.getItems().stream().filter(item -> toString.apply(item).equals(s)).findFirst().orElse(null);
            }
        });
        comboBox.setEditable(true);
        final FilteredList<T> filteredItems = comboBox.getItems().filtered(item -> true);

        SortedList<T> sorted = filteredItems.sorted((o1, o2) -> toString.apply(o1).compareToIgnoreCase(toString.apply(o2)));
        comboBox.getEditor().textProperty().addListener((observableValue, oldValue, newValue) -> {
            final T selected = comboBox.getSelectionModel().getSelectedItem();
            final TextField editor = comboBox.getEditor();

            Platform.runLater(() -> {
                if (selected == null || !toString.apply(selected).equals(editor.getText())) {
                    filteredItems.setPredicate(item -> toString.apply(item).toLowerCase().contains(newValue.toLowerCase()));
                    comboBox.setItems(sorted);
                    // To avoid focus on first item in list when space is pressed
                    ((ListView<?>) ((ComboBoxListViewSkin<?>) comboBox.getSkin()).getPopupContent()).getFocusModel().focus(-1);
                    comboBox.hide();
                    comboBox.show();
                }
            });
        });
    }

    public static void autoUpdateList(Runnable updateFunction) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        // Update the storage every minute
        scheduledExecutorService.scheduleAtFixedRate(updateFunction, 0, 20, TimeUnit.SECONDS);
    }
}
