package businesslogic.api.airplane;

import businesslogic.api.common.Identifiable;

public interface Airplane extends Identifiable<String> {
    String getPlaneType();

    int getMaxCapacity();
}
