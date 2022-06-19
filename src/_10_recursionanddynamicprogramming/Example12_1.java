package _10_recursionanddynamicprogramming;

import _3_arraysandstrings.datastructures.ArrayList;

import java.util.Arrays;

//Print all ways of placing 8 queens on an 8 X 8 board such that neither share a row or column or diagonal
//Each queen will be placed on a different row
//If a queen 0 is placed in (0, 0), queen 1 cannot be placed in (1, 1) or (1, 0)
public class Example12_1 {
    private static ArrayList<int[]> placeQueens(int size) {
        ArrayList<int[]> solutions = new ArrayList<>();
        int[] solution = new int[size];
        placeQueens(0, solution, solutions);
        return solutions;
    }

    private static void placeQueens(int row, int[] solution, ArrayList<int[]> solutions) {
        if (row == solution.length) {
            int[] copy = Arrays.copyOf(solution, solution.length);
            solutions.add(copy);
        } else {
            for (int col = 0; col < solution.length; col++) {
                if (checkValid(row, col, solution)) {
                    solution[row] = col;
                    placeQueens(row + 1, solution, solutions);
                }
            }
        }
    }

    private static boolean checkValid(int row, int column, int[] solution) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            if (solution[prevRow] == column) {
                return false;
            }
            int rowDistance = row - prevRow;
            int columnDistance = Math.abs(column - solution[prevRow]);
            if (rowDistance == columnDistance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<int[]> solutions = placeQueens(8);
        for (int[] solution : solutions)
            System.out.println(Arrays.toString(solution));
    }
}
