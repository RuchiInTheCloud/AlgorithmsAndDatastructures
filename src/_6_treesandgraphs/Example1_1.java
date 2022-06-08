package _6_treesandgraphs;

import _6_treesandgraphs.datastructures.Graph;

//Is there a route between two nodes
//Example:
// 0 -> 1, 4, 5
// 1 -> 3, 4
// 2 -> 1
// 3 -> 2, 4
// 4 ->
// 5 ->
//Brute force: BFS
//Complexity: If branching is k and distance between nodes is d, then complexity O(k^d)
//Optimize: Bidirectional search??
public class Example1_1 {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        graph.add("0", 0);
        graph.add("1", 1);
        graph.add("2", 2);
        graph.add("3", 3);
        graph.add("4", 4);
        graph.add("5", 5);

        graph.addEdge("0", "1");
        graph.addEdge("0", "4");
        graph.addEdge("0", "5");

        graph.addEdge("1", "3");
        graph.addEdge("1", "4");

        graph.addEdge("2", "1");

        graph.addEdge("3", "2");
        graph.addEdge("3", "4");

        System.out.println("Are Node 0 and 2 are connected? " + graph.breadthFirstSearch("0", "2"));
        System.out.println("Are Node 4 and 5 are connected? " + graph.breadthFirstSearch("4", "5"));
    }
}
