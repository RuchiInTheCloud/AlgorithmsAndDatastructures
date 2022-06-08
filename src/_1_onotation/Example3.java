package _1_onotation;

public class Example3 {
    // Tree of calls have a depth N
    // Branches = 2, Each level has twice as many calls as the previous one
    // Last layer has 2^N nodes
    // Levels are N + 1, Depth is N
    // 20 + 2^1 + 2^2 + .... + 2^N = O(2^N) = 2^(N+1) - 1
    // Time complexity = O(branches^depth)
    // Space complexity = O(N) --> Only O(N) calls exist in the stack at a given time
    static int f(int n) {
        if (n <= 0) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
    }

    public static void main(String[] args) {
        System.out.printf("%2d", f(15));
    }
}
