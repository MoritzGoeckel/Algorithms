package Graph;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    private final int id;
    private LinkedList<GraphEdge> outgoingEdges = new LinkedList<>();

    public GraphNode(int id){
        this.id = id;
    }

    public List<GraphEdge> getEdges(){
        return outgoingEdges;
    }

    public void addEdgeTo(GraphNode node){
        addEdgeTo(node, 0);
    }

    public void addEdgeTo(GraphNode node, int cost){
        outgoingEdges.add(new GraphEdge(node, cost));
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != GraphNode.class)
            return false;

        return ((GraphNode) obj).getId() == getId();
    }
}
