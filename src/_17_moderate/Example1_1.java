package _17_moderate;

//Assumption a > b
// Arithmetic Swap
//  a = a - b
//  b = a + b
//  a = b - a
// Logical Swap
//  x = x ^ y
//  y = x ^ y
//  x = x ^ y
//
//  Bitwise logical swap explanation
//  x = x ^ y, if both are same x is zero, otherwise 1
//  y = x ^ y, (0 if same, 1 if different) ^ y
//  x = x ^ y, (0 if same, 1 if different) ^ x_0
public class Example1_1 {
    public static void main(String[] args) {
        int a = 1000;
        int b = 100;
        System.out.println("Before a = " + a + ", b = " + b);
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("After   a = " + a + ", b = " + b);

        int x = 1000;
        int y = 100;
        System.out.println("Before x = " + x + ", y = " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After   x = " + x + ", y = " + y);
    }
}
