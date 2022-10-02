package _17_moderate.example10_1;

/*
Given list of peoples birth and death year. Find the year with the most people alive
O (P + R) --> R = Range of years, P = number of people
If person ist born and dies the same year array[year]++, array[year + 1]--
 */
public class Example10_4 {
    static int maxAliveYear(Person[] people, int min, int max) {
        int[] populationDeltas = getPopulationDeltas(people, min, max);
        int maxAliveYear = getMaxAliveYear(populationDeltas);
        return maxAliveYear + min;
    }

    static int[] getPopulationDeltas(Person[] people, int min, int max) {
        int[] populationDeltas = new int[max - min + 2];
        for (Person person : people) {
            int birth = person.birth - min;
            populationDeltas[birth]++;
            int death = person.death - min;
            populationDeltas[death + 1]--;
        }
        return populationDeltas;
    }

    static int getMaxAliveYear(int[] deltas) {
        int maxAliveYear = 0;
        int maxAlive = 0;
        int currentlyAlive = 0;
        for (int year = 0; year < deltas.length; year++) {
            currentlyAlive += deltas[year];
            if (currentlyAlive > maxAlive) {
                maxAlive = currentlyAlive;
                maxAliveYear = year;
            }
        }
        return maxAliveYear;
    }

    public static void main(String[] args) {
        Person[] people = {new Person(1900, 1999), new Person(1991, 1999)};
        System.out.println(maxAliveYear(people, 1900, 1999));
    }
}
