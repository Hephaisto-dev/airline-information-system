package gui;

import businesslogic.api.route.RouteCreator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CreateRouteController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    List<String> testData = new ArrayList<>(Arrays.asList("San Marino", "Capetown", "France", "Amsterdam",
            "Netherlands", "Los Angeles", "Tokyo", "Canada", "Peru", "Colombia", "Ecuador", "Brazil"));
    private RouteCreator routeCreator;

    @FXML
    private ListView<Button> addListView;

    @FXML
    private ListView<Button> removeListView;

    @FXML
    private TextField searchAdd;

    @FXML
    private TextField searchRemove;

    @FXML
    private Button submit;

    public CreateRouteController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.routeCreator = new RouteCreator();
    }

    @FXML
    void searchAddButton(ActionEvent event) {
        addListView.getItems().clear();
        addListView.getItems().addAll(searchButtonList(searchAdd.getText(), testData));
    }

    @FXML
    void searchRemoveButton(ActionEvent event) {
        removeListView.getItems().clear();
        removeListView.getItems().addAll(searchButtonList(searchRemove.getText(),
                removeListView.getItems().stream().map(Button::getText).collect(Collectors.toList())));
    }

    private List<Button> searchButtonList(String searchWords, List<String> listOfStrings) {
        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word -> input.toLowerCase().contains(word.toLowerCase()));
        }).map(input -> {
            Button button = new Button(input);
            button.setOnAction(event -> {
                addListView.getItems().remove(button);
                removeListView.getItems().add(new Button(input));
                listOfStrings.remove(input);
            });
            return button;
        }).collect(Collectors.toList());
    }

    @FXML
    private void handleAddListViewClick(MouseEvent event) {
        Button selectedButton = addListView.getSelectionModel().getSelectedItem();
        if (selectedButton != null) {
            addListView.getItems().remove(selectedButton);
            removeListView.getItems().add(new Button(selectedButton.getText()));
        }
    }

    @FXML
    private void handleRemoveListViewClick(MouseEvent event) {
        Button selectedButton = removeListView.getSelectionModel().getSelectedItem();
        if (selectedButton != null) {
            removeListView.getItems().remove(selectedButton);
            addListView.getItems().add(new Button(selectedButton.getText()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        addListView.getItems().addAll(testData.stream().map(s -> {
            Button button = new Button(s);
            button.setOnAction(event -> {
                addListView.getItems().remove(button);
                removeListView.getItems().add(new Button(s));
            });
            return button;
        }).collect(Collectors.toList()));

        addListView.setOnMouseClicked(this::handleAddListViewClick);

        removeListView.setOnMouseClicked(this::handleRemoveListViewClick);
    }

}
