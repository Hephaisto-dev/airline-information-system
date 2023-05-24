package gui;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.employee.EmployeeType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class LoginController implements Initializable {
    private final Supplier<SceneManager> sceneManagerSupplier;
    private final BusinessLogicAPI businessLogicAPI;
    @FXML
    private Button employeeBtn;
    @FXML
    private Button managerBtn;
    @FXML
    private Button officerBtn;

    public LoginController(Supplier<SceneManager> sceneManagerSupplier, BusinessLogicAPI businessLogicAPI) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.businessLogicAPI = businessLogicAPI;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeBtn.setOnAction(actionEvent -> {
            businessLogicAPI.setLoggedInEmployee(EmployeeType.SALES_EMPLOYEE);
            sceneManagerSupplier.get().changeScene("mainGUI");
        });
        managerBtn.setOnAction(actionEvent -> {
            businessLogicAPI.setLoggedInEmployee(EmployeeType.SALES_MANAGER);
            sceneManagerSupplier.get().changeScene("mainGUI");
        });
        officerBtn.setOnAction(actionEvent -> {
            businessLogicAPI.setLoggedInEmployee(EmployeeType.SALES_OFFICER);
            sceneManagerSupplier.get().changeScene("mainGUI");
        });
    }
}
