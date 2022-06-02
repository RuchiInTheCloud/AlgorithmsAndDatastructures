package arraysandstrings;

import java.util.Arrays;

//Listen: Rotate matrix by 90 in place
//Examples:
//123         741
//456   -->   852
//789         963
//1234       1951
//5678   --> 1162
//9101       2073
//1123       3184
//Brute force
//For i = 0 .. n/2-1
//last = n - 1 - i
//For j = i .. n - 1 - i - 1
//temp = matrix[i][j]
//matrix[i][j] = matrix[n-1-j][i]
//matrix[n-1-j][i] = matrix[last][n-1-j]
//matrix[last][n-1-j] = matrix[j][last]
//matrix[j][last] = temp
//Complexity: O(n^2)
//Optimize: BCR
//Complexity: O(n^2)
//WalkThrough
//helping variables: last, offset
//Implement
//Test: Check whether loop variables are correct
public class Example7_1 {
    public static void rotate(int[][] matrix, int n) {
        for (int i = 0; i < n / 2; i++) {
            int last = n - 1 - i;
            for (int j = i; j < n - 1 - i; j++) {
                // save top
                int temp = matrix[i][j];
                // move left to top
                matrix[i][j] = matrix[n - 1 - j][i];
                // move bottom to left
                matrix[n - 1 - j][i] = matrix[last][n - 1 - j];
                // move right to bottom
                matrix[last][n - 1 - j] = matrix[j][last];
                // move top to right
                matrix[j][last] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 1, 0, 1}, {1, 1, 2, 3}};

        System.out.println("Initial State: " + Arrays.deepToString(A));
        rotate(A, 4);
        System.out.println("90 degree rotation state: " + Arrays.deepToString(A));
    }
}
