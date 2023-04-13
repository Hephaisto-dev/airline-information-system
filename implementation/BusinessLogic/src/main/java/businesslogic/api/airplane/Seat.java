package businesslogic.api.airplane;

import businesslogic.api.common.StringIdentifiable;

public interface Seat extends StringIdentifiable {
    int getColumn();

    char getRow();
}
