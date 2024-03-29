package _10_recursionanddynamicprogramming;

//A child can hop 1 step, 2 steps, or 3 steps
//Find the number of ways it can hop up a staircase with n steps
//
//Find all the ways of deducting (-1, -2, -3) from n to arrive at 0
//
//Time complexity = O(3^n), Space complexity = O(n)
public class Example1_1 {
    private static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }
    public static void main(String[] args) {
        System.out.println("Ways to come down a staircase of 4 steps " + countWays(4));
    }
}
