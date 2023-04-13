package businesslogic.api.customer;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class PriceImplTest {

    private final CurrencyType Euro = CurrencyType.EURO;
    private final CurrencyType USDoll = CurrencyType.DOLLAR;

    private Price Cost1 = new PriceImpl(1250);
    private Price Cost2 = new PriceImpl(930, CurrencyType.DOLLAR);
    private Price Cost3 = new PriceImpl(1540, CurrencyType.EURO);


    @Test
    void applyDiscount( ) {
        SoftAssertions.assertSoftly(softly -> {
            Cost1.applyDiscount(1250);
            Cost2.applyDiscount(1250);
            Cost3.applyDiscount(1250);
            softly.assertThat(Cost1.getBackendPrice())
                    .isEqualTo(0);
            softly.assertThat(Cost2.getBackendPrice())
                    .isEqualTo(930);
            softly.assertThat(Cost3.getBackendPrice())
                    .isEqualTo(290);
        });
    }

    @Test
    void applyVoucher() {
        SoftAssertions.assertSoftly(softly -> {
            Cost1.applyDiscount(1250);
            Cost2.applyDiscount(1250);
            Cost3.applyDiscount(1250);
            softly.assertThat(Cost1.getBackendPrice())
                    .isEqualTo(0);
            softly.assertThat(Cost2.getBackendPrice())
                    .isEqualTo(930);
            softly.assertThat(Cost3.getBackendPrice())
                    .isEqualTo(290);
        });
    }

    @Test
    void chooseCurrency() {
        SoftAssertions.assertSoftly(softly->{
            Cost1.applyVoucher(20);
            Cost2.applyVoucher(30);
            softly.assertThat(Cost1.getBackendPrice())
                    .isEqualTo(1000);
            softly.assertThat(Cost2.getBackendPrice())
                    .isEqualTo(651);
        });
    }

    @Test
    void testToString() {
        SoftAssertions.assertSoftly(softly->{
            softly.assertThat(Cost1.toString())
                    .isEqualTo("12,50€");
            softly.assertThat(Cost2.toString())
                    .isEqualTo("9,30$");
            softly.assertThat(Cost3.toString())
                    .isEqualTo("15,40€");
        });
    }
}