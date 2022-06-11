package _8_mathandlogicpuzzles;

//There is a building of 100 floors. If an egg drops on nth floor or above it will break
//If it is dropped below, it does not break. You are given two eggs. Find n while minimizing
//the number of drops for the worst case
//If egg 1 break is attempted at floor 10, 20, 30...
//Say egg 1 breaks on floor 10, egg 2 needs to be dropped between floor 1, 2, .., 9 creating 10 drops total
//Say egg 1 breaks on floor 100, egg 2 needs to be dropped between floor 91, 92, .., 99 creating 19 drops total
//
//To balance the number of drops of both eggs, we can increment egg 1 at x, x - 1, x - 2 until egg 1 reaches floor 100
//x (x + 1) / 2 = 100
//x^2 + x - 200 = 0
//x = approx. 14
public class Example8_1 {
    static int breakingPoint = 84;
    static int drops = 0;

    private static boolean drop(int floor) {
        drops++;
        return floor >= breakingPoint;
    }

    private static int findBreakingPoint(int floors) {
        int interval = 14;
        int egg1 = 14;

        int previous = 0;
        while (!drop(egg1) && egg1 < floors) {
            interval--;
            previous = egg1;
            egg1 += interval;
        }

        int egg2 = previous + 1;
        while (!drop(egg2) && egg2 < floors && egg2 < egg1) {
            egg2 ++;
        }

        return egg2 > floors ? -1: egg2;
    }

    public static void main(String[] args) {
        System.out.println("Breaking Point is: " + findBreakingPoint(100));
    }
}
