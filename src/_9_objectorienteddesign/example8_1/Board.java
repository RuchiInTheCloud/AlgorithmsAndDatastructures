package _9_objectorienteddesign.example8_1;

public class Board {
    private Piece[][] board;
    private int blackCount = 0;
    private int whiteCount = 0;

    public Board(int rows, int columns) {
        board = new Piece[rows][columns];
    }

    public void initialize() {
        /* initial board has a grid like the following in the center:
         *     WB
         *     BW
         */
        int middleRow = (board.length - 1) / 2;
        int middleColumn = (board[middleRow].length - 1) / 2;
        board[middleRow][middleColumn] = new Piece(Color.White);
        board[middleRow + 1][middleColumn + 1] = new Piece(Color.White);
        board[middleRow][middleColumn + 1] = new Piece(Color.Black);
        board[middleRow + 1][middleColumn] = new Piece(Color.Black);
        blackCount = 2;
        whiteCount = 2;
    }

    public boolean placeColor(int row, int column, Color color) {
        if (board[row][column] != null) {
            return false;
        }

    }

    public int getScoreForColor(Color c) {
        if (c == Color.Black) {
            return blackCount;
        } else {
            return whiteCount;
        }
    }

    public void printBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    System.out.print("_");
                } else if (board[r][c].getColor() == Color.White) {
                    System.out.print("W");
                } else {
                    System.out.print("B");
                }
            }
            System.out.println();
        }
    }
}
