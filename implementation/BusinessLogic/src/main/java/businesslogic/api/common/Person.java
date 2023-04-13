package businesslogic.api.common;

import java.time.LocalDate;

public interface Person extends Nameable {
    String getFirstName();

    String getLastName();

    LocalDate getDob();
}
