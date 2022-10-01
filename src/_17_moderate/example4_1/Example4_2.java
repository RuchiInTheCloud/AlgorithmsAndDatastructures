package _17_moderate.example4_1;

//Design an algorithm to figure out if someone has won a game of tic-tac-toe
//Does hasWon have to be called once or several times (website). If latter is the case, we may want to add preprocessing time to improve runtime of hasWon
//Do we know the last move made?
//Do we design for 3X3 board or NXN board
//Prioritize compactness of code vs speed of execution vs clarity of code? Most efficient not best, should also be easy to understand and maintainable
//Solution 2: We know the last move
public class Example4_2 {
    private static Piece hasWon(Piece[][] board, int row, int column) {
        if (board.length != board[0].length)
            return Piece.Empty;
        if (row < 0 || row >= board.length || column < 0 || column >= board.length) {
            return Piece.Empty;
        }

        Piece piece = board[row][column];
        if (piece == Piece.Empty) {
            return Piece.Empty;
        }

        if (hasWonRow(board, row) || hasWonColumn(board, column)) {
            return piece;
        }

        if (row == column && hasWonDiagonal(board, 1)) {
            return piece;
        }

        if (row == board.length - column - 1 && hasWonDiagonal(board, -1)) {
            return piece;
        }

        return Piece.Empty;
    }

    private static boolean hasWonRow(Piece[][] board, int row) {
        for (int c = 1; c < board[0].length; c++) {
            if (board[row][0] != board[row][c]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasWonColumn(Piece[][] board, int col) {
        for (int r = 1; r < board[0].length; r++) {
            if (board[0][col] != board[r][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasWonDiagonal(Piece[][] board, int direction) {
        int row = 0;
        int col = direction == 1 ? 0 : board[0].length - 1;
        Piece first = board[row][col];
        for (int i = 0; i < board.length; i++) {
            if (first != board[row][col]) {
                return false;
            }
            row += 1;
            col += direction;
        }
        return true;
    }

    public static void main(String[] args) {
        Piece[][] board = {{Piece.Empty, Piece.Empty, Piece.Empty}, {Piece.Empty, Piece.Empty, Piece.Empty},
                {Piece.Blue, Piece.Blue, Piece.Blue}};

        System.out.println(hasWon(board, 2, 2));
    }
}