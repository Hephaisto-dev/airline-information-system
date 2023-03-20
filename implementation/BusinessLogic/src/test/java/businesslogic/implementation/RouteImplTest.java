package businesslogic.implementation;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RouteImplTest {

    private RouteImpl Route = new RouteImpl("DEPART", "ARRIVE");

    @Test
    void getDeparturePlace() {
        SoftAssertions.assertSoftly(softly->{
            softly.assertThat(Route.getDeparturePlace())
                    .isEqualTo("DEPART");
        });
    }

    @Test
    void getArrivalPlace() {
        SoftAssertions.assertSoftly(softly->{
            softly.assertThat(Route.getArrivalPlace())
                    .isEqualTo("ARRIVAL");
        });
    }

    @Test
    void testToString() {
        String expect = "RouteImpl{arriveIn='" + Route.getArrivalPlace() + "\'";
        expect += ", departFrom='" + Route.getDeparturePlace() + "\'" + "}";
        String finalExpect = expect;
        SoftAssertions.assertSoftly(softly->{
            softly.assertThat(Route.toString())
                    .isEqualTo(finalExpect);
        });
    }
}