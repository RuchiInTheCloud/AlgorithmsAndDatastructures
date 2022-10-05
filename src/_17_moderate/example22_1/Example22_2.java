package _17_moderate.example22_1;

import java.util.HashSet;

/*
Ant sits on infinite grid of white and black squares. Initially faces right
At every step
- At white square, flip color, turn 90 clockwise and move by one unit
- At black square, flip color, turn 90 anticlockwise and move by one unit
Simulate first k moves and print board as grid

HashSet:
- We only need list of white squares
- If position is in hash set then it is white
- Keep track of top left and bottom right corner
- With each ant move, update the corner position if necessary
 */
public class Example22_2 {
    static class Board {
        HashSet<Position> whites = new HashSet<>();
        Ant ant = new Ant();
        Position topLeftCorner = new Position(0, 0);
        Position bottomRightCorner = new Position(0, 0);

        public void move() {
            ant.turn(isWhite(ant.position));
            flip(ant.position);
            ant.move();
            ensureFit(ant.position);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            int rowMin = topLeftCorner.row;
            int rowMax = bottomRightCorner.row;
            int colMin = topLeftCorner.column;
            int colMax = bottomRightCorner.column;

            for (int r = rowMin; r <= rowMax; r++) {
                for (int c = colMin; c <= colMax; c++) {
                    if (r == ant.position.row && c == ant.position.column) {
                        sb.append(ant.orientation);
                    } else if (isWhite(r, c)) {
                        sb.append("X");
                    } else {
                        sb.append("_");
                    }
                }
                sb.append("\n");
            }
            sb.append("Ant: " + ant.orientation + ". \n");
            return sb.toString();
        }

        private void flip(Position p) {
            if (whites.contains(p)) {
                whites.remove(p);
            } else {
                whites.add(p.clone());
            }
        }

        private void ensureFit(Position position) {
            int row = position.row;
            int column = position.column;

            topLeftCorner.row = Math.min(row, topLeftCorner.row);
            topLeftCorner.column = Math.min(column, topLeftCorner.column);

            bottomRightCorner.row = Math.max(row, bottomRightCorner.row);
            bottomRightCorner.column = Math.max(column, bottomRightCorner.column);
        }

        private boolean isWhite(Position p) {
            return whites.contains(p);
        }

        private boolean isWhite(int row, int column) {
            return isWhite(new Position(row, column));
        }
    }
}
