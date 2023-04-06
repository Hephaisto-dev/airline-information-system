package businesslogic.api.airplane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SeatImplTest {

    private final String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char charmant = Alphabet.charAt(2);

    private final Seat sitter = new SeatImpl(charmant, 21);

    @Test
    void getID() {
        assertThat(sitter.getId())
                .isEqualTo("21C");
    }

    @Test
    void getColumn() {
        assertThat(sitter.getColumn())
                .isEqualTo('C');
    }

    @Test
    void getRow() {
        assertThat(sitter.getRow())
                .isEqualTo(21);
    }
}