package businesslogic.api.customer;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class CurrencyTypeTest {

    @Test
    void getCurrencyType() {
        SoftAssertions.assertSoftly(
                softly -> {
                    for (CurrencyType currencyType : CurrencyType.values()) {
                        softly.assertThat(currencyType.getCurrencyType(currencyType.getCurrency().getCurrencyCode()))
                                .isEqualTo(currencyType);
                    }
                }
        );
    }
}