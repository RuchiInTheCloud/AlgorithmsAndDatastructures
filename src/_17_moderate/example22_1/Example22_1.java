package _17_moderate.example22_1;

/*
Ant sits on infinite grid of white and black squares. Initially faces right
At every step
- At white square, flip color, turn 90 clockwise and move by one unit
- At black square, flip color, turn 90 anticlockwise and move by one unit
Simulate first k moves and print board as grid

Fixed array:
- One could create 2k X 2k grid and place ant in center
- Not extensible approach if another k steps desired
- Wastes space if ant is going in circles

Resizable array:
- Grow array as necessary and offer amortized insertion
- Grow 2d array in all dimensions +x, -x, +y, -y
- Each time an ant hits an edge, we double th grid in that dimension
- (Negative indices converted to positive via offset)
- When ant travels into negative coordinates, double the size of the array and move ant and
 all cells into positive coordinates, by relabelling indices
 */
public class Example22_1 {
    static class Grid {
        private boolean[][] grid;
        private Ant ant = new Ant();

        public Grid() {
            grid = new boolean[1][1];
        }

        public void move() {
            ant.turn(grid[ant.position.row][ant.position.column]);
            flip(ant.position);
            ant.move();
            ensureFit(ant.position);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (r == ant.position.row && c == ant.position.column) {
                        sb.append(ant.orientation);
                    } else if (grid[r][c]) {
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

        private void flip(Position position) {
            int row = position.row;
            int column = position.column;
            grid[row][column] = grid[row][column] ? false : true;
        }

        private void ensureFit(Position position) {
            int shiftRow = 0;
            int shiftColumn = 0;
            int numRows = grid.length;
            if (position.row < 0) {
                shiftRow = numRows;
                numRows *= 2;
            } else if (position.row >= numRows) {
                numRows *= 2;
            }

            int numColumns = grid[0].length;
            if (position.column < 0) {
                shiftColumn = numColumns;
                numColumns *= 2;
            } else if (position.column >= numColumns) {
                numColumns *= 2;
            }

            if (numRows != grid.length || numColumns != grid[0].length) {
                boolean[][] newGrid = new boolean[numRows][numColumns];
                copyWithShift(grid, newGrid, shiftRow, shiftColumn);
                ant.adjustPosition(shiftRow, shiftColumn);
                grid = newGrid;
            }
        }

        private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftColumn) {
            for (int r = 0; r < oldGrid.length; r++) {
                for (int c = 0; c < oldGrid[0].length; c++) {
                    newGrid[r + shiftRow][c + shiftColumn] = oldGrid[r][c];
                }
            }
        }
    }
}
