package Graph;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    private LinkedList<GraphEdge> outgoingEdges;

    public List<GraphEdge> getEdges(){
        return outgoingEdges;
    }

    public void addEdgeTo(GraphNode node, int cost){
        outgoingEdges.add(new GraphEdge(node, cost));
    }
}
