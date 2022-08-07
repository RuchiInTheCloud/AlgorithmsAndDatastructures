package _3_arraysandstrings;

import java.util.Arrays;

//Given: If an MXN matrix has an element that is zero set its row and column to zero
//Example:
// 11011        00000
// 11111        01011
// 01011  --->  00000
// 11111        01011
// 11111        01011
//Brute force: When you encounter a zero set the column and row to zero
//Complexity: time: O(N^3)
//Brute force: Record the row with a zero in an array, Record the the column with a zero in an array
//Complexity: time: O(N^2), space: O(N)
//Walk through:
//help variable: boolean rowHasZero, boolean columnHasZero
//Iterate through the first row, record in rowHasZero when zero is encountered
//Iterate through the first column, record in columnHasZero when zero is encountered
//Iterate through the array, make marking in the first row or first column when zero is encountered
//Iterate through the row array to "nullify the rows" in the matrix as indicated by the first row
//Iterate through the column array to "nullify the columns" in the matrix as indicated by the first column
//Nullify first row if rowHasZero
//Nullify first column if columnHasZero
//Test:
public class Example8_2 {
    private static void setZeros(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }
        if (columnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    public static void nullifyRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println("Initial matrix: " + Arrays.deepToString(matrix));
        setZeros(matrix);
        System.out.println("Matrix after zeros set: " + Arrays.deepToString(matrix));
    }
}
