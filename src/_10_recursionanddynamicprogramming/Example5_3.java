package _10_recursionanddynamicprogramming;

//Write a recursive function to multiply two positive integers without using * or /
//You may use addition, subtraction or bitwise shifting but minimize the number of these operations
//product (n,m) = product (n/2, m) + product (n/2, m)
//
//              5, 10
//      2, 10
//1, 10
//
//O(log s), space complexity O(log s)
public class Example5_3 {
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
            if (smaller % 2 == 1) {
                return halfProduct + halfProduct + larger;
            } else {
                return halfProduct + halfProduct;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Product of 3 and 5: " + product(5, 10));
    }
}
