package _17_moderate.example4_1;

import _3_arraysandstrings.datastructures.ArrayList;

import java.lang.reflect.Array;
import java.util.Iterator;

public class Example4_6 {
    static Piece hasWon(Piece[][] board) {
        if (board.length != board[0].length)
            return Piece.Empty;
        int size = board.length;

        ArrayList<PositionIterator> instructions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            instructions.add(new PositionIterator(new Position(i, 0), 0, 1, size));
            instructions.add(new PositionIterator(new Position(0, i), 1, 0, size));
        }
        instructions.add(new PositionIterator(new Position(0, 0), 1, 1, size));
        instructions.add(new PositionIterator(new Position(0, size - 1), 1, -1, size));

        for (PositionIterator iterator : instructions) {
            Piece winner = hasWon(board, iterator);
            if (winner != Piece.Empty) {
                return winner;
            }
        }
        return Piece.Empty;
    }

    static Piece hasWon(Piece[][] board, PositionIterator iterator) {
        Position firstPosition = iterator.next();
        Piece first = board[firstPosition.row][firstPosition.column];
        while (iterator.hasNext()) {
            Position position = iterator.next();
            if (first != board[position.row][position.column]) {
                return Piece.Empty;
            }
        }
        return first;
    }

    static class PositionIterator implements Iterator<Position> {
        private Position current;
        private int size;
        int rowIncrement;
        int columnIncrement;

        public PositionIterator(Position p, int rowI, int colI, int size) {
            this.rowIncrement = rowI;
            this.columnIncrement = colI;
            this.size = size;
            current = new Position(p.row - rowI, p.column - colI);
        }

        @Override
        public boolean hasNext() {
            return current.row + rowIncrement < size && current.column + columnIncrement < size;
        }

        @Override
        public Position next() {
            current = new Position(current.row + rowIncrement, current.column + columnIncrement);
            return current;
        }
    }

    static class Position {
        public int row;
        public int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        Piece[][] board = {{Piece.Empty, Piece.Empty, Piece.Empty}, {Piece.Empty, Piece.Empty, Piece.Empty},
                {Piece.Blue, Piece.Blue, Piece.Blue}};

        System.out.println(hasWon(board));
    }
}
