package businesslogic.api;

import businesslogic.api.manager.CustomerManager;

/**
 * API of the BusinessLogic layer.
 *
 * @author Informatics Fontys Venlo
 */
public interface BusinessLogicAPI {

    CustomerManager getCustomerManager();
}
