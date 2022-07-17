package _16_threadsandlocks.example7_1;

//Print the numbers between 1 and N
//When number divisible by 3, print Fizz
//When number divisible by 5, print Buzz
//When number divisible by 15, print FizzBuzz
//Perform in multithreaded way
public class Example7_1 {
    private static void fizzbuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        fizzbuzz(100);
    }
}
