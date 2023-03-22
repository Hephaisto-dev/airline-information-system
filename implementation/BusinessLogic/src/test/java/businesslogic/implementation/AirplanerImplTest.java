package businesslogic.implementation;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class AirplanerImplTest {

    private AirplaneImpl Airplane = new AirplaneImpl("Id", "type", 2);

    @Test
    void getId() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getId())
                    .isEqualTo("Id");

        });
    }

    @Test
    void getPlaneType() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getId())
                    .isEqualTo("type");
        });
    }

    @Test
    void getMaxCapacity() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(Airplane.getMaxCapacity())
                    .isEqualTo(2);
        });
    }

}
