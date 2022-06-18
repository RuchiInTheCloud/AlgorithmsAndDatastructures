package _10_recursionanddynamicprogramming;

//Write a recursive function to multiply two positive integers without using * or /
//You may use addition, subtraction or bitwise shifting but minimize the number of these operations
//product (n,m) = product (n/2, m) + product (n/2, m)
//
//              5, 10
//      2, 10         3, 10
//1, 10          1, 10      2, 10
//
//O(2^(log s)) = O(s) time complexity?, space complexity O(log s)
public class Example5_2 {
    static int product(int n, int m) {
        int smaller = n < m ? n : m;
        int larger = n > m ? n : m;
        int[] memo = new int[smaller + 1];
        return productHelper(smaller, larger, memo);
    }

    private static int productHelper(int smaller, int larger, int[] memo) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return larger;
        } else if (memo[smaller] > 0) {
            return memo[smaller];
        } else {
            System.out.println("I was here. Smaller = " + smaller + ", Larger = " + larger);

            int temp = smaller >> 1;
            int halfProduct = productHelper(temp, larger, memo);
            int otherHalfProduct = halfProduct;
            if (smaller % 2 == 1) {
                otherHalfProduct = productHelper(smaller - temp, larger, memo);
            }
            memo[smaller] = halfProduct + otherHalfProduct;
            return memo[smaller];
        }
    }

    public static void main(String[] args) {
        System.out.println("Product of 3 and 5: " + product(5, 10));
    }
}
