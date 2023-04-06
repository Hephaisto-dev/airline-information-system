package businesslogic.api.airplane;

public class SeatImpl implements Seat{
    private final char column;
    private final int row;

    public SeatImpl(char ColumnLR, int rowUD){
        this.column = ColumnLR;
        this.row = rowUD;
    }



    @Override
    public String getId() {
        return row + String.valueOf(column);
    }

    @Override
    public char getColumn() {
        return column;
    }

    @Override
    public int getRow() {
        return row;
    }
}
