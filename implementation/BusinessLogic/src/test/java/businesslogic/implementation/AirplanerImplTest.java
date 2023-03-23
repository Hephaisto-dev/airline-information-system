package businesslogic.implementation;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class AirplanerImplTest {

    private AirplaneImpl Airplane = new AirplaneImpl("Id", "name", 2);

    @Test
    void testGetId() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getId())
                    .isEqualTo("Id");

        });
    }

    @Test
    void testGetPlaneName() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getName())
                    .isEqualTo("name");
        });
    }

    @Test
    void testGetMaxCapacity() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getCapacity())
                    .isEqualTo(2);
        });
    }
}
