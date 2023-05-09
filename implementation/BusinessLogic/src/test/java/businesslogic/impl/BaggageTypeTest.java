package businesslogic.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BaggageTypeTest {

    @Test
    void getBaggage() {
        for (BaggageType baggageType : BaggageType.values()) {
            assertEquals(BaggageType.getBaggage(baggageType.getBaggage().getId()), baggageType.getBaggage());
        }
        assertNull(BaggageType.getBaggage(0));
    }
}