package _17_moderate.example4_1;

//Design an algorithm to figure out if someone has won a game of tic-tac-toe
//Does hasWon have to be called once or several times (website). If latter is the case, we may want to add preprocessing time to improve runtime of hasWon
//Do we know the last move made?
//Do we design for 3X3 board or NXN board
//Prioritize compactness of code vs speed of execution vs clarity of code? Most efficient not best, should also be easy to understand and maintainable
//Solution 3: 3X3 board
public class Example4_3 {
    static Piece hasWon(Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (hasWinner(board[i][0], board[i][1], board[i][2])) {
                return board[i][0];
            }
            if (hasWinner(board[i][0], board[i][1], board[i][2])) {
                return board[i][0];
            }
        }
        if (hasWinner(board[0][0], board[1][1], board[2][2])) {
            return board[0][0];
        }
        if (hasWinner(board[2][0], board[1][1], board[0][2])) {
            return board[2][0];
        }
        return Piece.Empty;
    }

    private static boolean hasWinner(Piece p1, Piece p2, Piece p3) {
        if (p1 == Piece.Empty) {
            return false;
        }
        return p1 == p2 && p2 == p3;
    }
    public static void main(String[] args) {
        Piece[][] board = {{Piece.Empty, Piece.Empty, Piece.Empty}, {Piece.Empty, Piece.Empty, Piece.Empty},
                {Piece.Blue, Piece.Blue, Piece.Blue}};

        System.out.println(hasWon(board));
    }
}
