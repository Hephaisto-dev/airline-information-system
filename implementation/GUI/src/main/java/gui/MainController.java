package gui;

import java.util.function.Supplier;

public class MainController {

    private final Supplier<SceneManager> sceneManagerSupplier;

    public MainController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    public void sendToLogin() {
        sceneManagerSupplier.get().changeScene("loginView");
    }

}
