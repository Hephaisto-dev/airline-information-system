module gui_module {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires businesslogic_module;
    requires java.sql;
    requires java.desktop;

    opens gui to javafx.fxml;

    exports gui;
}
