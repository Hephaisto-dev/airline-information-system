package businesslogic.api.airplane;

public class SeatImpl implements Seat{
    private char column;
    private int row;

    public SeatImpl(char ColumnLR, int rowUD){
        this.column = ColumnLR;
        this.row = rowUD;
    }



    @Override
    public String getID() {
        return row + "" + column;
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
