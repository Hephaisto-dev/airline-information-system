package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AirplaneImplTest {

    private final Airplane Airplane = new AirplaneImpl("Id", "name", 2, 1);
    private final Airplane Plane2 = new AirplaneImpl("Id", "name", 25, 4);

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

    @Test
    void testCapacity2() {
        assertThat(Plane2.getCapacity())
                .isEqualTo(100);
    }

    @Test
    void testGetLength() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getLength())
                    .isEqualTo(2);
            softly.assertThat(Plane2.getLength())
                    .isEqualTo(25);
        });
    }

    @Test
    void testGetWidth() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getWidth())
                    .isEqualTo(1);
            softly.assertThat(Plane2.getWidth())
                    .isEqualTo(4);
        });
    }
}
