package _9_objectorienteddesign.example8_1;

public class Location {
    private int row;
    private int column;

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isSameAs(int r, int c) {
        return row == r && column == c;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
