package onotation;

public class Example2 {
    //Time complexity: O(n)
    //Space complexity: O(1)
    static int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }

    private static int pairSum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.printf("%2d", pairSumSequence(5));
    }
}
