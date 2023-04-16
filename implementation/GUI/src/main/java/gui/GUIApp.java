package gui;

import businesslogic.api.BusinessLogicAPI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.InputStream;


/**
 * persistence.impl.Main GUI App. Gets Business Logic injected. Delegates the switching of scenes
 * to the SceneManager. The controllerFactory takes care of instantiating the
 * controllers. This enables you to use parameterized constructors and to inject
 * (as in the example below regarding the CustomerController) a link to the
 * business logic layer. Invocation / initialization of this JavaFX app has been
 * slightly adapted compared to a default generated JavaFX app. See documentation
 * above show() method.
 *
 * @author Informatics Fontys Venlo
 */
public class GUIApp extends Application {

    private static final String INITIAL_VIEW = "mainGUI";

    private BusinessLogicAPI businessLogicAPI;
    private SceneManager sceneManager;
    private final Callback<Class<?>, Object> controllerFactory = (Class<?> c)
            -> switch (c.getName()) {
        //case "gui.LoginWindowController" -> new LoginWindowController(businessLogicAPI.)
        case "gui.CustomerController" ->
                new CustomerController(this::getSceneManager, businessLogicAPI.getCustomerManager());
        case "gui.PrimaryController" -> new PrimaryController(this::getSceneManager);
        case "gui.SecondaryController" -> new SecondaryController(this::getSceneManager);
        case "gui.MainController" -> new MainController(this::getSceneManager);
        case "gui.CreateBookingController" ->
                new CreateBookingController(this::getSceneManager, businessLogicAPI.getBookingManager());
        case "gui.CreateFlightController" ->
                new CreateFlightController(this::getSceneManager, businessLogicAPI.getFlightManager());
        case "gui.CreateAirportController" -> new CreateAirportController(this::getSceneManager,
                businessLogicAPI.getAirportManager());
        case "gui.SearchBookingController" -> new SearchBookingController(businessLogicAPI.getBookingManager());
        case "gui.CreateTicketController" -> new CreateTicketController(businessLogicAPI.getFlightManager());
        default -> null;
    };

    public GUIApp(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }

    /**
     * Normally, a JavaFX application has a main method that invokes the
     * launch() method. Since we want to instantiate the GUIApp ourselves,
     * in order to be able to inject a link to the Business Logic, we have to
     * rewrite the initialization process. This method is meant for invocation
     * from the assembler. It will trigger the initialization of the JavaFX
     * Toolkit. From a GUI test context, typically the init() method will be
     * invoked with 'false' as parameter, since the JavaFXToolkit doesn't need
     * to be initialized in that case.
     *
     * @return GUIApp
     */
    public GUIApp show() {
        return init(true);
    }

    GUIApp init(boolean startJavaFXToolkit) {

        if (startJavaFXToolkit) {

            Platform.startup(() -> {
            });

            initializeSceneManager();

            Platform.runLater(() -> {
                Stage stage = new Stage();
                start(stage);
            });

        } else {
            initializeSceneManager();
        }

        return this;
    }

    private void initializeSceneManager() {
        sceneManager = new SceneManager(controllerFactory, INITIAL_VIEW);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Airline Information System");
        InputStream resourceAsStream = getClass().getResourceAsStream("images/logo.jpg");
        if (resourceAsStream != null) {
            stage.getIcons().add(new Image(resourceAsStream));
        }
        sceneManager.displayOn(stage);
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }
}
