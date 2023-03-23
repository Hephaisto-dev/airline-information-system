package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AirplaneImplTest {

    private final Airplane Airplane = new AirplaneImpl("Id", "name", 2);

    @Test
    void testGetId() {
        assertThat(Airplane.getId())
                .isEqualTo("Id");
    }

    @Test
    void testGetPlaneName() {
        assertThat(Airplane.getName())
                .isEqualTo("name");
    }

    @Test
    void testGetMaxCapacity() {
        assertThat(Airplane.getCapacity())
                .isEqualTo(2);
    }
}
