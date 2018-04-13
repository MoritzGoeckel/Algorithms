package Graph;

public class GraphEdge {

    private GraphNode destinationNode;
    private int cost;

    public GraphEdge(GraphNode destinationNode, int cost){
        this.destinationNode = destinationNode;
        this.cost = cost;
    }

    public GraphNode getDestinationNode() {
        return destinationNode;
    }

    public int getCost() {
        return cost;
    }
}
