module gui_module {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires businesslogic_module;
    requires fontawesomefx;

    opens gui to javafx.fxml;

    exports gui;
}
