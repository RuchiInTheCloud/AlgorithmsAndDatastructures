package treesandgraphs.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void testBreadthFirstSearch() {
        Graph<Integer> graph = new Graph<>();

        graph.add(0);
        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.add(4);
        graph.add(5);

        graph.add(0, 1);
        graph.add(0, 4);
        graph.add(0, 5);

        graph.add(1, 3);
        graph.add(1, 4);

        graph.add(2, 1);

        graph.add(3, 2);
        graph.add(3, 4);

        assertTrue(graph.breadthFirstSearch(0, 2));
        assertFalse(graph.breadthFirstSearch(4, 5));
    }
}
