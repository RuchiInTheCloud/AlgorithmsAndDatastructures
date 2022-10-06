package _17_moderate;

import java.util.Random;

/*
Rand7 from Rand5
Rand5 generates 0 .. 4
Write method to generate 0 .. 6 each with equal probability
 */
public class Example23_1 {
    static int rand5() {
        Random random = new Random();
        return random.nextInt(5);
    }

    /*
    Every pair is equally likely by 1 / 25
    4 has probability 5 / 25: 0, 4; 1, 3; 2, 2; 3, 1; 4, 0
    0 has probability 3 / 25: 0, 0; 3, 4; 4, 3
    Each value returned does not have probability 1 / 7
     */
    static int rand7_1() {

        int v = rand5() + rand5();
        return v % 7;
    }

    /*
    As long as we can list of the combinations of rand5() that will result in a particular value for rand7()
    the function will not give well distributed results
    Discard values between 21 and 24 as this makes rand7() unfairly weighted towards 0 ... 3
    No guarantee on the number of rand5() calls that generate a given value
     */
    static int rand7_2() {
        while (true) {
            int v = 5 * rand5() + rand5();
            if (v < 21) {
                return v % 7;
            }
        }
    }

    /*
    5*rand5+rand5 gives each number 0 ... 24 with equal probability
    2*rand5+rand5 does not give each number with equal probability; 6 = 2*1+4; 2*2+2; 2*3+0; 0 = 2*0+0
     */
    static int rand7_3() {
        while (true) {
            int r1 = 2 * rand5(); /*even between 0 and 8*/
            int r2 = rand5();
            if (r2 != 4) { /*discard extra even number*/
                int rand1 = r2 % 2;
                int num = r1 + rand1; /*range is between 0 and 9*/
                if (num < 7) {
                    return num;
                }
            }
        }
    }
}
