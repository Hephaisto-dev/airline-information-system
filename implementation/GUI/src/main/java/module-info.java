module gui_module {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires businesslogic_module;

    opens gui to javafx.fxml;

    exports gui;
}
