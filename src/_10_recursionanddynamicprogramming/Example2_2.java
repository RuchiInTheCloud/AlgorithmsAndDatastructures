package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.HashTable;
import _4_linkedlists.datastructures.LinkedList;

//Robot can move right or down
//Determine the path from top left to bottom right if it exists
//
// X X 0 X X
// X 0 0 X X
// 0 0 0 X X
// X X X 0 X
// X X X X X
//
//Points once observed to not lead to source via any route are earmarked as false are not visited twice.
//Time complexity: O(rc), space complexity: O(rc)
public class Example2_2 {
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
        HashTable<Point, Boolean> cache = new HashTable<>();
        boolean found = findPath(maze, maze.length - 1, maze[0].length - 1, path, cache);
        return found ? path : null;
    }

    private static boolean findPath(boolean[][] maze, int row, int column, LinkedList<Point> path,
            HashTable<Point, Boolean> cache) {

        if (row < 0 || column < 0 || !maze[row][column]) {
            return false;
        }

        Point point = new Point(row, column);
        if (cache.containsKey(point)) {
            return cache.get(point);
        }

        boolean success = false;
        boolean isAtOrigin = (row == 0 && column == 0);
        if (isAtOrigin || findPath(maze, row - 1, column, path, cache) || findPath(maze, row, column - 1, path,
                cache)) {
            path.addLast(point);
            success = true;
        }

        cache.put(point, success);
        return success;
    }

    public static void main(String[] args) {
        boolean[][] maze = {{true, true, false, true, true}, {true, false, false, true, true},
                {false, false, false, true, true}, {true, true, true, false, true}, {true, true, true, true, true}};
        LinkedList<Point> path = findPath(maze);
        System.out.println("Path found " + (path == null ? null : path.string()));
    }
}
