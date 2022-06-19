package _10_recursionanddynamicprogramming;

import java.util.Arrays;

//number of ways of representing n cents via 25, 10, 5, 1

public class Example11_2 {
    private static int makeChange(int n, int[] denoms) {
        int[][] map = new int[n + 1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    private static int makeChange(int n, int[] denoms, int index, int[][] map) {
        if (index >= denoms.length - 1) {
            return 1;
        }
        if (map[n][index] > 0) {
            return map[n][index];
        } else {
            int denom = denoms[index];
            int ways = 0;
            for (int i = 0; i * denom <= n; i++) {
                ways += makeChange(n - i * denom, denoms, index + 1, map);
            }
            map[n][index] = ways;
            return map[n][index];
        }
    }

    public static void main(String[] args) {
        int[] denoms = {25, 10, 5, 1};
        int count = makeChange(100, denoms);
        System.out.println("100 can be made via denominations " + Arrays.toString(denoms) + " in " + count + " ways");
    }
}
