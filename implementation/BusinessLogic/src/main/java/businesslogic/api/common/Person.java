package businesslogic.api.common;

import java.time.LocalDate;

public interface Person extends Nameable {
    String getFirstName();

    String getLastName();

    String getEmail();

    LocalDate getDob();
}
