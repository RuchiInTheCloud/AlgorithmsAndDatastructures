package _1_onotation;

public class Example1 {
    //Space complexity: O(n)
    //Time complexity: O(n)
    //sum(4)
    // --> sum(3)
    //      --> sum(2)
    //          --> sum(1)
    //               --> sum(0)
    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.printf("%2d", sum(15));
    }
}
