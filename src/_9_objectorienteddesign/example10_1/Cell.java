package _9_objectorienteddesign.example10_1;

public class Cell {
    private int row;
    private int column;
    private boolean isBomb;
    private int number;
    private boolean isExposed;
    private boolean isGuess;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;

        isBomb = false;
        number = 0;
        isExposed = false;
        isGuess = false;
    }

    public void setRowAndColumn(int r, int c) {
        row = r;
        column = c;
    }

    public void setBomb() {
        isBomb = true;
        number = -1;
    }

    public void incrementNumber() {
        number++;
    }

    public boolean toggleGuess() {
        if (!isExposed) {
            isGuess = !isGuess;
        }
        return isGuess;
    }

    public boolean isBlank() {
        return number == 0;
    }

    public boolean flip() {
        isExposed = true;
        return !isBomb;
    }

    public String getSurfaceState() {
        if (isExposed) {
            return getUndersideState();
        } else if (isGuess) {
            return "B ";
        } else {
            return "? ";
        }
    }

    public String getUndersideState() {
        if (isBomb) {
            return "* ";
        } else if (number > 0) {
            return number + " ";
        } else {
            return "  ";
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public boolean isGuess() {
        return isGuess;
    }

    public boolean isBomb() {
        return isBomb;
    }
}
