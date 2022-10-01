package _17_moderate.example4_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class Example4_5 {
    static class Check {
        public int row, column;
        private int rowIncrement, colIncrement;

        public Check(int row, int column, int rowIncrement, int colIncrement) {
            this.row = row;
            this.column = column;
            this.rowIncrement = rowIncrement;
            this.colIncrement = colIncrement;
        }

        public void increment() {
            this.row += rowIncrement;
            this.column += colIncrement;
        }

        public boolean inBounds(int size) {
            return row >= 0 && column >= 0 && row < size && column < size;
        }
    }

    static Piece hasWon(Piece[][] board) {
        if (board.length != board[0].length)
            return Piece.Empty;
        int size = board.length;
        ArrayList<Check> instructions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            instructions.add(new Check(i, 0, 0, 1));
            instructions.add(new Check(0, i, 1, 0));
        }
        instructions.add(new Check(0, 0, 1, 1));
        instructions.add(new Check(0, size - 1, 1, -1));

        for (Check instr : instructions) {
            Piece winner = hasWon(board, instr);
            if (winner != Piece.Empty) {
                return winner;
            }
        }
        return Piece.Empty;
    }

    static Piece hasWon(Piece[][] board, Check instr) {
        Piece first = board[instr.row][instr.column];
        while (instr.inBounds(board.length)) {
            if (first != board[instr.row][instr.column]) {
                return Piece.Empty;
            }
            instr.increment();
        }
        return first;
    }

    public static void main(String[] args) {
        Piece[][] board = {{Piece.Empty, Piece.Empty, Piece.Empty}, {Piece.Empty, Piece.Empty, Piece.Empty},
                {Piece.Blue, Piece.Blue, Piece.Blue}};

        System.out.println(hasWon(board));
    }
}
