package businesslogic.impl;

import businesslogic.api.baggage.Baggage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class BaggageImplTest {

    @Test
    void testGetters() {
        Baggage baggage = BaggageType.SMALL.getBaggage();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(baggage.getId()).isEqualTo(1);
            softly.assertThat(baggage.isCargo()).isFalse();
            softly.assertThat(baggage.isCarryOn()).isTrue();
            softly.assertThat(baggage.getHeight()).isEqualTo(55);
            softly.assertThat(baggage.getWidth()).isEqualTo(35);
            softly.assertThat(baggage.getLength()).isEqualTo(20);
            softly.assertThat(baggage.getWeight()).isEqualTo(8);
        });
    }
}