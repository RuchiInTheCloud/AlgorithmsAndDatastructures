package _11_systemdesignandscalability.example2_1;

import _3_arraysandstrings.datastructures.ArrayList;
import _3_arraysandstrings.datastructures.HashTable;
import _4_linkedlists.datastructures.LinkedList;

import java.util.HashSet;

//friendId
//Person: id, List of ids
//Visited: Hashset of ids
//PathNode: Person, previous node
//ToVisit: Queue of PathNode
public class QuestionA {
    public static LinkedList<Person> findPathBFS(HashTable<Integer, Person> people, int source, int destination) {
        LinkedList<PathNode> toVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        toVisit.addLast(new PathNode(people.get(source), null));
        visited.add(source);

        while (!toVisit.isEmpty()) {
            PathNode node = toVisit.removeFront().data;
            Person person = node.getPerson();
            if (person.getPersonID() == destination) {
                return node.collapse(false);
            }

            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!visited.contains(friendId)) {
                    visited.add(friendId);
                    Person friend = people.get(friendId);
                    toVisit.addLast(new PathNode(friend, node));
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nPeople = 11;
        HashTable<Integer, Person> people = new HashTable<>();
        for (int i = 0; i < nPeople; i++) {
            Person p = new Person(i);
            people.put(i, p);
        }

        int[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};

        for (int[] edge : edges) {
            Person source = people.get(edge[0]);
            source.addFriend(edge[1]);

            Person destination = people.get(edge[1]);
            destination.addFriend(edge[0]);
        }

        int i = 1;
        int j = 10;
        LinkedList<Person> path1 = findPathBFS(people, i, j);
        Tester.printPeople(path1);
    }
}
