package _10_recursionanddynamicprogramming;

import java.util.Arrays;

//A child can hop 1 step, 2 steps, or 3 steps
//Find the number of ways it can hop up a staircase with n steps
//
//Find all the ways of deducting (-1, -2, -3) from n to arrive at 0
//
//f(0) = 1
//f(1) = 1
//f(2) = f(0) + f(1)
//f(3) = f(2) + f(1) + f(0)
//
//Time complexity = O(n), Space complexity = O(n)
public class Example1_2 {
    private static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        System.out.println("Ways to come down a staircase of 4 steps " + countWays(4));
    }
}
