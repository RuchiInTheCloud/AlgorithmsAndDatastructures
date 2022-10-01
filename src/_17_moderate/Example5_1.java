package _17_moderate;

/*
Factorial Zeros - compute trailing zeros in n!
Count the number of times 5 appears between 2 and n
*/
public class Example5_1 {
    static int factorsOf5(int num) {
        int count = 0;
        while (num % 5 == 0) {
            num = num / 5;
            count += 1;
        }
        return count;
    }

    static int countFactZeros(int num) {
        int count = 0;
        for (int i = 5; i <= num; i++) {
            count += factorsOf5(i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countFactZeros(50));
    }
}
