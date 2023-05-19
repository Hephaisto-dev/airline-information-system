package gui;

import java.util.function.Supplier;
public class FooterController {
    private final Supplier<SceneManager> sceneManagerSupplier;

    public FooterController(Supplier<SceneManager> sceneManagerSupplier){
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
}
