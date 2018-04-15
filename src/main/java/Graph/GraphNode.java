package Graph;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    private final int id;
    private LinkedList<GraphEdge> outgoingEdges;

    public GraphNode(int id){
        this.id = id;
    }

    public List<GraphEdge> getEdges(){
        return outgoingEdges;
    }

    public void addEdgeTo(GraphNode node, int cost){
        outgoingEdges.add(new GraphEdge(node, cost));
    }

    public int getId() {
        return id;
    }
}
