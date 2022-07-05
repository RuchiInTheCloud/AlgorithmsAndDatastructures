package _12_sortingandsearching;

//Given MXN matrix with sorted rows and columns. Write method to find element.
//Bruteforce: O(MlogN). Execute binary search in every row.
//15   20   40   85
//20   35   80   95
//30   55   95  105
//40   80  100  120
//
public class Example9_2 {
    private static class Coordinate implements Cloneable {
        public int row;
        public int column;

        public Coordinate(int r, int c) {
            row = r;
            column = c;
        }

        public boolean isBefore(Coordinate p) {
            return row <= p.row && column <= p.column;
        }

        @Override
        public Coordinate clone() {
            return new Coordinate(row, column);
        }

        public void setToAverage(Coordinate min, Coordinate max) {
            row = (min.row + max.row) / 2;
            column = (min.column + max.column) / 2;
        }

        public boolean inbounds(int[][] matrix) {
            return row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length;
        }

        public String toString() {
            return row + ", " + column;
        }
    }

    private static Coordinate findElement(int[][] matrix, int x) {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
        return findElement(matrix, origin, dest, x);
    }

    private static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
        if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
            return null;
        }
        if (matrix[origin.row][origin.column] == x) {
            return origin;
        } else if (!origin.isBefore(dest)) {
            return null;
        }

        Coordinate start = origin.clone();
        int diagDist = Math.min(dest.column - origin.column, dest.row - origin.row);
        Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
        Coordinate pivot = new Coordinate(0, 0);

        while (start.isBefore(end)) {
            pivot.setToAverage(start, end);
            if (matrix[pivot.row][pivot.column] < x) {
                start.row = pivot.row + 1;
                start.column = pivot.column + 1;
            } else {
                end.row = pivot.row - 1;
                end.column = pivot.column - 1;
            }
        }

        return partitionAndSearch(matrix, origin, dest, start, x);
    }

    private static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot,
            int x) {
        Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
        Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
        Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
        Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);

        Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, x);
        if (lowerLeft == null) {
            return findElement(matrix, upperRightOrigin, upperRightDest, x);
        }
        return lowerLeft;
    }

    public static void main(String[] args) {
        int[][] matrix = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        Coordinate coordinate = findElement(matrix, 35);
        System.out.println(coordinate);
    }
}
