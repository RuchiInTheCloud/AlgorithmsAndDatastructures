package _17_moderate.example10_1;

/*
Given list of peoples birth and death year. Find the year with the most people alive
O (RP) --> R = Range of years, P = number of people
 */
public class Example10_2 {
    static int maxAliveYear(Person[] people, int min, int max) {
        int[] years = createYearMap(people, min, max);
        int best = getMaxIndex(years);
        return best + min;
    }

    static int[] createYearMap(Person[] people, int min, int max) {
        int[] years = new int[max - min + 1];
        for (Person person : people) {
            incrementRange(years, person.birth - min, person.death - min);
        }
        return years;
    }

    static void incrementRange(int[] values, int left, int right) {
        for (int i = left; i <= right; i++)
            values[i] += 1;
    }

    static int getMaxIndex(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Person[] people = {new Person(1900, 1999), new Person(1991, 1999)};
        System.out.println(maxAliveYear(people, 1900, 1999));
    }
}
