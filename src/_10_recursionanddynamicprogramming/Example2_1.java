package _10_recursionanddynamicprogramming;

import _4_linkedlists.datastructures.LinkedList;

//Robot can move right or down
//Determine the path from top left to bottom right if it exists
//
//Top down approach:
//Path(x,y) = Path(x-1, y) + (x, y) || Path(x, y-1) + (x, y)
//Base case: If x == 0, y == 0 return true
//           If x, y out of bounds, or (x, y) unavailable return false
// X X X X X
// X 0 X X X
// X X 0 X X
// 0 X X 0 X
// 0 0 X X X
//
//                              (4, 4)
//                        (3, 4)     (4, 3)
//                    (2, 4) (3, 3)
//                (1, 4)
//            (0, 4) (1, 3)
//        (-1, 4) (0, 3)
//            (-1, 3) (0, 2)
//                (-1, 2) (0, 1)
//                   (-1, 1) (0, 0)
//Time complexity: O(2^(r+c)), even though only rc squares, space complexity: O(r+c)
public class Example2_1 {
    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private static LinkedList<Point> findPath(boolean[][] maze) {
        LinkedList<Point> path = new LinkedList<>();
        boolean found = findPath(maze, maze.length - 1, maze[0].length - 1, path);
        return found ? path : null;
    }

    private static boolean findPath(boolean[][] maze, int row, int column, LinkedList<Point> path) {
        if (row < 0 || column < 0 || !maze[row][column]) {
            return false;
        }

        boolean isAtOrigin = (row == 0 && column == 0);

        if (isAtOrigin || findPath(maze, row - 1, column, path) || findPath(maze, row, column - 1, path)) {
            path.addLast(new Point(row, column));
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true, true, true}, {true, false, true, true, true},
                {true, true, false, true, true}, {false, true, true, false, true}, {false, false, true, true, true}};
        LinkedList<Point> path = findPath(maze);
        System.out.println("Path found " + (path == null ? null : path.string()));
    }
}
