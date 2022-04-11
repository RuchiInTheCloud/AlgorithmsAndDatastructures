package onotation;

public class Example22 {
    //Time complexity O(log n)
    static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(123));
    }
}
