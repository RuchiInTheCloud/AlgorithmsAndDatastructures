package _17_moderate.example4_1;

import java.util.HashMap;

//Design an algorithm to figure out if someone has won a game of tic-tac-toe
//Does hasWon have to be called once or several times (website). If latter is the case, we may want to add preprocessing time to improve runtime of hasWon
//Do we know the last move made?
//Do we design for 3X3 board or NXN board
//Prioritize compactness of code vs speed of execution vs clarity of code? Most efficient not best, should also be easy to understand and maintainable
//Solution 1: hasWon to be called multiple times
//Setup hashtable with all possible boards as keys and the value indicating who has won
public class Example4_1 {
    enum Piece {
        Empty,
        Red,
        Blue
    }

    static HashMap<Integer, Piece> winnerHashTable = new HashMap<>();

    private static Piece hasWon(int board) {
        return winnerHashTable.get(board);
    }

    private static int convertBoard(Piece[][] board) {
        if (board.length != board[0].length)
            return -1;
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int value = board[i][j].ordinal();
                sum = sum * 3 + value;
            }
        }
        return sum;
    }
}
