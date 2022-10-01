package _10_recursionanddynamicprogramming;

//Write a recursive function to multiply two positive integers without using * or /
//You may use addition, subtraction or bitwise shifting but minimize the number of these operations
//product (n,m) = product (n/2, m) + product (n/2, m)
//
//Complexity = O(log n)
//
//              5, 10
//      2, 10         3, 10
//1, 10          1, 10      2, 10
//                      1, 10
//
//           8, 10
//       4, 10
//    2, 10
// 1, 10
//
//
//O(2^(log s)) = O(s) time complexity?, space complexity O(log s)
public class Example5_1 {
    static int product(int n, int m) {
        int smaller = n < m ? n : m;
        int larger = n > m ? n : m;
        return productHelper(smaller, larger);
    }

    private static int productHelper(int smaller, int larger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return larger;
        } else {
            int half = smaller >> 1;
            int halfProduct = productHelper(half, larger);
            int otherHalfProduct = halfProduct;
            if (smaller % 2 == 1) {
                otherHalfProduct = productHelper(smaller - half, larger);
            }
            return halfProduct + otherHalfProduct;
        }
    }

    public static void main(String[] args) {
        System.out.println("Product of 3 and 5: " + product(5, 10));
    }
}
