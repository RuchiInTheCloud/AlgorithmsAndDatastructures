package _10_recursionanddynamicprogramming;

import java.util.Arrays;

//number of ways of representing n cents via 25, 10, 5, 1
//make change(100) = makechange(using 0 quarter) + makechange(using 1 quarter) +
//                  makechange(using 2 quarter) + makechange(using 3 quarter) + makechange(using 4 quarter)
//make change(75) = makechange(using 0 dime) + makechange(using 1 dime) + ... + makechange(using 7 dime)
//...
public class Example11_1 {
    private static int makeChange(int n, int[] denoms) {
        return makeChange(n, denoms, 0);
    }

    private static int makeChange(int n, int[] denoms, int index) {
        if (index >= denoms.length - 1) {
            return 1;
        }

        int denom = denoms[index];
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, denoms, index + 1);
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] denoms = {25, 10, 5, 1};
        int count = makeChange(100, denoms);
        System.out.println("100 can be made via denominations " + Arrays.toString(denoms) + " in " + count + " ways");
    }

}
