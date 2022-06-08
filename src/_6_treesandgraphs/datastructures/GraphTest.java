package _6_treesandgraphs.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void testBreadthFirstSearch() {
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

        assertTrue(graph.breadthFirstSearch("0", "2"));
        assertFalse(graph.breadthFirstSearch("4", "5"));
    }
}
