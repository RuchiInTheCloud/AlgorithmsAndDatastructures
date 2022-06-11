package _8_mathandlogicpuzzles;

import java.util.Random;

//All families must ensure 1 girl
//Every family continues to have child until they have a girl
//What will the gender ratio in the new world be?
//Odds of having a girl or a boy are equal
//
//P (G) = 1/2
//P (BG) = 1/4
//P (BBG) = 1/8
//P (BBBG) = 1/16
//...
//#B = 1/4 + 1/4 + 3/16 + ... = 1
//The birth policy seems ineffective
//Half the new borns are boys and half girls
public class Example7_1 {
    private static double runNFamilies(int n) {
        int girls = 0;
        int boys = 0;
        for (int i = 0; i < n;  i++) {
            int[] children = runOneFamily();
            girls += children[0];
            boys += children[1];
        }
        return (double) girls / (girls + boys);
    }

    private static int[] runOneFamily() {
        int girls = 0;
        int boys = 0;

        Random random = new Random();
        while (girls == 0) {
            if (random.nextBoolean()) {
                girls += 1;
            } else {
                boys += 1;
            }
        }
        return new int[]{girls, boys};
    }

    public static void main(String[] args) {
        System.out.println(runNFamilies(100));
    }
}
