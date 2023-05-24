package businesslogic.api;

import businesslogic.impl.BusinessLogicAPIImpl;

/**
 * Factory to provide BusinessLogicAPI implementation.
 *
 * @author Informatics Fontys Venlo
 */
public interface BusinessLogicFactory {

    /**
     * Get BusinessLogicAPI implementation.
     *
     * @return a singleton instance of the BusinessLogicAPI implementation.
     */
    static BusinessLogicAPI getImplementation() {
        return BusinessLogicAPIImpl.INSTANCE;
    }
}
