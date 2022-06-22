package _11_systemdesignandscalability.example2_1;

import _4_linkedlists.datastructures.LinkedList;

public class PathNode {
    private Person person;
    private PathNode previousNode;
    public PathNode(Person p, PathNode previous) {
        person = p;
        previousNode = previous;
    }

    public Person getPerson() {
        return person;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot) {
        LinkedList<Person> path = new LinkedList<>();
        PathNode node = this;
        while (node != null) {
            if (startsWithRoot) {
                path.addLast(node.person);
            } else {
                path.addFront(node.person);
            }
            node = node.previousNode;
        }
        return path;
    }
}
