package businesslogic.api.baggage;

import businesslogic.api.common.Identifiable;

public interface Baggage extends Identifiable<Integer> {
    /**
     * Get whether the baggage is carry on
     * @return true if the baggage is carry on, false otherwise
     */
    boolean isCarryOn();

    /**
     * Get whether the baggage is cargo
     * @return true if this baggage is cargo, false otherwise
     */
    boolean isCargo();

    /**
     * Get the height in cm
     * @return the height in cm
     */
    int getHeight();

    /**
     * Get the width in cm
     * @return the width in cm
     */
    int getWidth();

    /**
     * Get the length in cm
     * @return the length in cm
     */
    int getLength();

    /**
     * Get the maximum weight in kg
     * @return the maximum weight in kg
     */
    int getWeight();
}
