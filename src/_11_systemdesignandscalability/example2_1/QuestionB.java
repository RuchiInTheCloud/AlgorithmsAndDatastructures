package _11_systemdesignandscalability.example2_1;

import _3_arraysandstrings.datastructures.ArrayList;
import _3_arraysandstrings.datastructures.HashTable;
import _4_linkedlists.datastructures.LinkedList;

//Hashmap<id, Person>
//Person: id, List of ids
//PathNode: Person, previous node
//Visited: Hashmap of <id, pathNode>
//ToVisit: Queue of PathNode
public class QuestionB {
    public static LinkedList<Person> findPathBiBFS(HashTable<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));
        while (!sourceData.isFinished() && !destData.isFinished()) {
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getPersonID());
            }

            /* Search out from destination. */
            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getPersonID());
            }
        }
        return null;
    }

    public static Person searchLevel(HashTable<Integer, Person> people, BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            /* Pull out first node. */
            PathNode pathNode = primary.toVisit.removeFront().data;
            int personId = pathNode.getPerson().getPersonID();

            /* Check if it's already been visited. */
            if (secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.addLast(next);
                }
            }
        }
        return null;
    }

    public static LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection); // end1 -> source
        PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
        LinkedList<Person> pathOne = end1.collapse(false); // forward: source -> connection
        LinkedList<Person> pathTwo = end2.collapse(true); // reverse: connection -> dest
        pathTwo.removeFront(); // remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
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
        LinkedList<Person> path2 = findPathBiBFS(people, i, j);
        Tester.printPeople(path2);
    }
}
