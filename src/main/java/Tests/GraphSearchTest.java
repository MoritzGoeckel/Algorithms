package Tests;

import Graph.GraphNode;
import Graph.GraphSearch;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphSearchTest {

    private int id = 1;
    private GraphNode g1 = new GraphNode(id++);
    private GraphNode g2 = new GraphNode(id++);
    private GraphNode g3 = new GraphNode(id++);
    private GraphNode g4 = new GraphNode(id++);
    private GraphNode g5 = new GraphNode(id++);
    private GraphNode g6 = new GraphNode(id++);
    private GraphNode g7 = new GraphNode(id++);

    {
        g1.addEdgeTo(g2);
        g1.addEdgeTo(g3);
        g3.addEdgeTo(g4);
        g4.addEdgeTo(g1);
        g4.addEdgeTo(g6);
        g5.addEdgeTo(g4);
        g2.addEdgeTo(g7);
    }

    @Test
    void depthFirstSearchTest() {
        StringBuilder sb = new StringBuilder();

        GraphSearch.depthFirstSearch(g1,
            n -> {
                sb.append(" ").append(n.getId());
                return true;
            }
        );

        assertEquals(" 1 3 4 6 2 7", sb.toString());
    }

    @Test
    void breadthFirstSearch() {
        StringBuilder sb = new StringBuilder();

        Map<GraphNode, Integer> distances = GraphSearch.breadthFirstSearch(g1,
                n -> {
                    sb.append(" ").append(n.getId());
                    return true;
                }
        );

        assertEquals(" 1 2 3 4 6 7", sb.toString());
        assertEquals(new Integer(0), distances.get(g1));
        assertEquals(new Integer(1), distances.get(g2));
        assertEquals(new Integer(1), distances.get(g3));
        assertEquals(new Integer(2), distances.get(g4));
        assertEquals(false, distances.containsKey(g5));
        assertEquals(new Integer(3), distances.get(g6));
        assertEquals(new Integer(2), distances.get(g7));
    }
}
