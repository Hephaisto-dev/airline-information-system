package assembler;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.BusinessLogicFactory;
import gui.GUIApp;

/**
 * Assembler to setup layers and start the GUI.
 *
 * @author Informatics Fontys Venlo
 */
public class Assembler {

    public static void main(String[] args) {
        BusinessLogicAPI businesslogicAPI = BusinessLogicFactory.getImplementation();

        new GUIApp(businesslogicAPI).show();
    }
}
