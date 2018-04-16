package Tests;

import Graph.GraphNode;
import Graph.GraphSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphSearchTest {

    GraphNode testGraphStart;

    {
        int id = 1;
        GraphNode g1 = new GraphNode(id++);
        GraphNode g2 = new GraphNode(id++);
        GraphNode g3 = new GraphNode(id++);
        GraphNode g4 = new GraphNode(id++);
        GraphNode g5 = new GraphNode(id++);
        GraphNode g6 = new GraphNode(id++);
        GraphNode g7 = new GraphNode(id++);

        g1.addEdgeTo(g2);
        g1.addEdgeTo(g3);
        g3.addEdgeTo(g4);
        g4.addEdgeTo(g1);
        g4.addEdgeTo(g6);
        g5.addEdgeTo(g4);
        g2.addEdgeTo(g7);

        testGraphStart = g1;
    }

    @Test
    void depthFirstSearchTest() {
        StringBuilder sb = new StringBuilder();

        GraphSearch.depthFirstSearch(testGraphStart,
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

        GraphSearch.breadthFirstSearch(testGraphStart,
                n -> {
                    sb.append(" ").append(n.getId());
                    return true;
                }
        );

        assertEquals(" 1 2 3 4 6 7", sb.toString());
    }
}
