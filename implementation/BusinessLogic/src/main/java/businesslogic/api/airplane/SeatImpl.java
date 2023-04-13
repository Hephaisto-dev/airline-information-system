package businesslogic.api.airplane;

public class SeatImpl implements Seat {
    private final int column;
    private final char row;

    public SeatImpl(char rowUD, int ColumnLR) {
        this.column = ColumnLR;
        this.row = rowUD;
    }


    @Override
    public String getId() {
        return column + String.valueOf(row);
    }

    @Override
    public char getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
