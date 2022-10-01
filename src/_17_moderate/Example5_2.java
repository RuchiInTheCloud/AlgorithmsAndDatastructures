package _17_moderate;

/*
Factorial Zeros - compute trailing zeros in n!
Count multiples of 5, 25,.. between 1 and n
*/
public class Example5_2 {
    static int countFactZeros(int num) {
        int count = 0;
        if (num < 0) {
            return -1;
        }

        for (int i = 5; num / i > 0; i = i * 5) {
            count += num / i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countFactZeros(50));
    }
}
