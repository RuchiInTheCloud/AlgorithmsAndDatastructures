package _17_moderate.example22_1;

public class Ant {
    public Position position = new Position(0, 0);
    public Orientation orientation = Orientation.right;

    public void turn(boolean clockwise) {
        orientation = orientation.getTurn(clockwise);
    }

    public void move() {
        switch (orientation) {
            case left:
                position.column--;
                break;
            case right:
                position.column++;
                break;
            case up:
                position.row--;
                break;
            case down:
                position.row++;
                break;
        }
    }

    public void adjustPosition(int shiftRow, int shiftColumn) {
        position.row += shiftRow;
        position.column += shiftColumn;
    }
}
