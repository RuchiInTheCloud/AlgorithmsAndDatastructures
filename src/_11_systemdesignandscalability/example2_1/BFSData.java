package _11_systemdesignandscalability.example2_1;

import _3_arraysandstrings.datastructures.HashTable;
import _4_linkedlists.datastructures.LinkedList;

public class BFSData {
    public LinkedList<PathNode> toVisit = new LinkedList<>();
    public HashTable<Integer, PathNode> visited = new HashTable<>();

    public BFSData(Person root) {
        PathNode sourcePath = new PathNode(root, null);
        toVisit.addLast(sourcePath);
        visited.put(root.getPersonID(), sourcePath);
    }

    public boolean isFinished() {
        return toVisit.isEmpty();
    }
}
