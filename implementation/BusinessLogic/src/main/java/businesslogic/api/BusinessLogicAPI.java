package businesslogic.api;

import businesslogic.api.customer.CustomerManager;

/**
 * API of the BusinessLogic layer.
 *
 * @author Informatics Fontys Venlo
 */
public interface BusinessLogicAPI {

    CustomerManager getCustomerManager();

}
