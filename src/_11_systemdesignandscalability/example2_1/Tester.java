package _11_systemdesignandscalability.example2_1;

import _4_linkedlists.datastructures.LinkedList;

public class Tester {
    public static void printPeople(LinkedList<Person> path) {
        System.out.println(path == null ? "No path" : path.string());
    }
}
