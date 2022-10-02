package _17_moderate.example10_1;

/*
Given list of peoples birth and death year. Find the year with the most people alive
O (RP) --> R = Range of years, P = number of people
 */
public class Example10_1 {
    static int maxAliveYear(Person[] people, int min, int max) {
        int maxAlive = 0;
        int maxAliveYear = min;
        for (int year = min; year <= max; year++) {
            int alive = 0;
            for (Person person : people) {
                if (person.birth <= year & year <= person.death) {
                    alive += 1;
                }
            }
            if (alive > maxAlive) {
                maxAlive = alive;
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
