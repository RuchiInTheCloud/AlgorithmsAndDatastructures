package _10_recursionanddynamicprogramming;

//A child can hop 1 step, 2 steps, or 3 steps
//Find the number of ways it can hop up a staircase with n steps
//
//Find all the ways of deducting (-1, -2, -3) from n to arrive at 0
//
//f(-1) = 0
//f(0) = 1
//f(1) = 1
//f(2) = f(1) + f(0) + f(-1)
//f(3) = f(2) + f(1) + f(0)
//f(4) = f(3) + f(2) + f(1)
//
//Time complexity = O(n), Space complexity = O(1)
public class Example1_3 {
    private static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        int a, b, c, d;
        a = b = d = 0;
        c = 1;

        for (int i = 1; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

    public static void main(String[] args) {
        System.out.println("Ways to come down a staircase of 4 steps " + countWays(4));
    }
}
