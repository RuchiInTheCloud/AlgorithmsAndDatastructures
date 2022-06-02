package arraysandstrings;

import java.util.Arrays;

//Given: If an MXN matrix has an element that is zero set its row and column to zero
//Example:
// 11111        11011
// 11111        11011
// 11011  --->  00000
// 11111        11011
// 11111        11011
//Brute force: When you encounter a zero set the column and row to zero
//Complexity: time: O(N^3)
//Brute force: Record the row with a zero in an array, Record the the column with a zero in an array
//Complexity: time: O(N^2), space: O(N)
//Walk through:
//Iterate through the array, make marking in the above arrays when zero is encountered
//Iterate through the row array to "nullify the rows" in the matrix as indicated by the row array
//Iterate through the column array to "nullify the columns" in the matrix as indicated by the column array
//Test:
public class Example8_2 {
    private static void setZeros(int[][] matrix) {
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println("Initial matrix: " + Arrays.deepToString(matrix));
        setZeros(matrix);
        System.out.println("Matrix after zeros set: " + Arrays.deepToString(matrix));
    }
}
