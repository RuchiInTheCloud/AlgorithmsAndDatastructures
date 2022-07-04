package _12_sortingandsearching;

//Given MXN matrix with sorted rows and columns. Write method to find element.
//Bruteforce: O(MlogN). Execute binary search in every row.
//15   20   40   85
//20   35   80   95
//30   55   95  105
//40   80  100  120
//
//If start of column is greater than the value, then look to the left
//If end of row is smaller than the value, then look below
public class Example9_1 {
    private static boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        boolean isPresent = findElement(matrix, 55);
        System.out.println(isPresent);
    }
}