package _17_moderate.example4_1;

//Design an algorithm to figure out if someone has won a game of tic-tac-toe
//Does hasWon have to be called once or several times (website). If latter is the case, we may want to add preprocessing time to improve runtime of hasWon
//Do we know the last move made?
//Do we design for 3X3 board or NXN board
//Prioritize compactness of code vs speed of execution vs clarity of code? Most efficient not best, should also be easy to understand and maintainable
//Solution 4: NXN board
public class Example4_4 {
    static Piece hasWon(Piece[][] board) {
        int size = board.length;
        if (board[0].length != size)
            return Piece.Empty;

        Piece first;
        for (int i = 0; i < size; i++) {
            first = board[i][0];
            if (first == Piece.Empty)
                continue;
            for (int j = 1; j < size; j++) {
                if (board[i][j] != first) {
                    break;
                } else if (j == size - 1) {
                    return first;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            first = board[0][i];
            if (first == Piece.Empty)
                continue;
            for (int j = 1; j < size; j++) {
                if (board[j][i] != first) {
                    break;
                } else if (j == size - 1) {
                    return first;
                }
            }
        }

        first = board[0][0];
        if (first != Piece.Empty) {
            for (int j = 1; j < size; j++) {
                if (board[j][j] != first) {
                    break;
                } else if (j == size - 1) {
                    return first;
                }
            }
        }

        first = board[0][size - 1];
        if (first != Piece.Empty) {
            for (int j = 1; j < size; j++) {
                if (board[j][size - 1 - j] != first) {
                    break;
                } else if (j == size - 1) {
                    return first;
                }
            }
        }

        return Piece.Empty;
    }

    public static void main(String[] args) {
        Piece[][] board = {{Piece.Empty, Piece.Empty, Piece.Empty}, {Piece.Empty, Piece.Empty, Piece.Empty},
                {Piece.Blue, Piece.Blue, Piece.Blue}};

        System.out.println(hasWon(board));
    }
}
