package _10_recursionanddynamicprogramming;

import _5_stacksandqueues.datastructures.Stack;

//Robot can move right or down
//Determine the path from top left to bottom right if it exists
//
// X X X X X
// X 0 X X X
// X X 0 X X
// 0 X X 0 X
// 0 0 X X X
public class Example2_3 {
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

    static Stack<Point> findPath(boolean[][] maze) {
        Stack<Point> stack = new Stack<>();
        findPath(maze, 0, 0, stack);
        return stack;
    }

    static boolean findPath(boolean[][] maze, int sourceX, int sourceY, Stack<Point> path) {
        if (sourceX > maze.length - 1 || sourceY > maze[0].length - 1 || !maze[sourceX][sourceY]) {
            return false;
        }

        boolean isAtDestination = (sourceX == maze.length - 1 && sourceY == maze[0].length - 1);

        if (isAtDestination || findPath(maze, sourceX + 1, sourceY, path) || findPath(maze, sourceX, sourceY + 1, path)) {
            path.push(new Point(sourceX, sourceY));
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true, true, true}, {true, false, true, true, true},
                {true, true, false, true, true}, {false, true, true, false, true}, {false, false, true, true, true}};
        Stack<Point> path = findPath(maze);
        System.out.println("Path found " + path);
    }
}
