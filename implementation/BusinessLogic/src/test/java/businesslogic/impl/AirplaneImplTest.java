package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import datarecords.AirplaneData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AirplaneImplTest {

    private final Airplane Airplane = new AirplaneImpl(new AirplaneData("Id", "manufacturers", 2, 1, "models", 100));
    private final Airplane Plane2 = new AirplaneImpl(new AirplaneData("name", "manufacturers", 25, 1, "models", 100));

    @Disabled
    @Test
    void testGetId() {
        assertThat(Airplane.getId())
                .isEqualTo("Id");
    }

    @Disabled
    @Test
    void testGetPlaneName() {
        assertThat(Plane2.getId())
                .isEqualTo("name");
    }

    @Disabled
    @Test
    void testGetMaxCapacity() {
        assertThat(Airplane.getSeats())
                .isEqualTo(100);
    }

    @Disabled
    @Test
    void testCapacity2() {
        assertThat(Plane2.getSeats())
                .isEqualTo(100);
    }

    @Disabled
    @Test
    void testGetLength() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getLength())
                    .isEqualTo(2);
            softly.assertThat(Plane2.getLength())
                    .isEqualTo(25);
        });
    }

    @Disabled
    @Test
    void testGetWidth() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getWidth())
                    .isEqualTo(1);
            softly.assertThat(Plane2.getWidth())
                    .isEqualTo(1);
        });
    }
}
