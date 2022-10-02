package _17_moderate.example10_1;

import java.util.Arrays;

/*
Given list of peoples birth and death year. Find the year with the most people alive
O (P log P) --> P = number of people
 */
public class Example10_3 {
    static int maxAliveYear(Person[] people, int min, int max) {
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);
        int birthIndex = 0;
        int deathIndex = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = min;

        while (birthIndex < births.length) {
            if (births[birthIndex] <= deaths[deathIndex]) {
                currentlyAlive++;
                if (currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;
                    maxAliveYear = births[birthIndex];
                }
                birthIndex++;
            } else if (births[birthIndex] > deaths[deathIndex]) {
                currentlyAlive--;
                deathIndex++;
            }
        }
        return maxAliveYear;
    }

    static int[] getSortedYears(Person[] people, boolean copyBirthYear) {
        int[] years = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }
        Arrays.sort(years);
        return years;
    }

    public static void main(String[] args) {
        Person[] people = {new Person(1900, 1999), new Person(1991, 1999)};
        System.out.println(maxAliveYear(people, 1900, 1999));
    }
}
