package assembler;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.BusinessLogicFactory;
import gui.GUIApp;
import persistence.PersistenceAPI;
import persistence.PersistenceFactory;

/**
 * Assembler to setup layers and start the GUI.
 *
 * @author Informatics Fontys Venlo
 */
public class Assembler {

    public static void main(String[] args) {

        PersistenceAPI persistenceAPI = PersistenceFactory.getImplementation();
        BusinessLogicAPI businesslogicAPI = BusinessLogicFactory.getImplementation(persistenceAPI);

        new GUIApp(businesslogicAPI).show();
    }
}
