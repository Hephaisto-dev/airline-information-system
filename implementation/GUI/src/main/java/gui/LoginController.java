package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import businesslogic.api.employee.EmployeeType;
import businesslogic.api.BusinessLogicAPI;
public class LoginController implements Initializable {
    private final Supplier<SceneManager> sceneManagerSupplier;
    private BusinessLogicAPI businessLogicAPI;

    @FXML
    private Button employeeBtn;

    @FXML
    private TextField idField;

    @FXML
    private Button managerBtn;

    @FXML
    private Button officerBtn;


    public LoginController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    @FXML
    public void onButtonClicked(ActionEvent event) {
        int idType = Integer.parseInt(idField.getText());
        EmployeeType currentType = EmployeeType.fromId(idType);

        if(currentType == EmployeeType.SALES_OFFICER){
            businessLogicAPI.setLoggedInEmployee(EmployeeType.SALES_OFFICER);
            //store the employee type somewhere so that you can pass it to the navBarController
            sceneManagerSupplier.get().changeScene("mainGUI");
        }else if(currentType == EmployeeType.SALES_MANAGER){
            businessLogicAPI.setLoggedInEmployee(EmployeeType.SALES_MANAGER);
            sceneManagerSupplier.get().changeScene("mainGUI");
        } else if (currentType == EmployeeType.SALES_EMPLOYEE) {
            businessLogicAPI.setLoggedInEmployee(EmployeeType.SALES_EMPLOYEE);
            sceneManagerSupplier.get().changeScene("mainGUI");
        }
        // Perform actions based on the entered idType
        // sceneManagerSupplier.get().getLoginView().showElementsForIdType(idType);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
