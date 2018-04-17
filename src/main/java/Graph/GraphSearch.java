package Graph;

import java.util.*;
import java.util.function.Predicate;

public class GraphSearch {

    public static Map<GraphNode, Integer> breadthFirstSearch(GraphNode start, Predicate<GraphNode> markOperation){
        Set<GraphNode> visitedNodes = new HashSet<>();
        Stack<GraphNode> queue = new Stack<>();
        Map<GraphNode, Integer> distances = new HashMap<>();

        queue.push(start);
        distances.put(start, 0);

        visitedNodes.add(start);
        if(!markOperation.test(start))
            return distances;

        while (!queue.empty()){
            GraphNode node = queue.pop();
            for(GraphEdge e : node.getEdges()) {
                GraphNode neighbour = e.getDestinationNode();
                if(!visitedNodes.contains(neighbour)) {
                    queue.push(e.getDestinationNode());
                    visitedNodes.add(neighbour);

                    distances.put(neighbour, distances.get(node) + 1);

                    if (!markOperation.test(neighbour))
                        return distances;
                }
            }
        }

        return distances;
    }

    public static void depthFirstSearch(GraphNode start, Predicate<GraphNode> markOperation){
        Set<GraphNode> visitedNodes = new HashSet<>();
        Stack<GraphNode> queue = new Stack<>();

        queue.push(start);

        while (!queue.empty()){
            GraphNode node = queue.pop();
            if(!visitedNodes.contains(node)){
                visitedNodes.add(node);
                for(GraphEdge e : node.getEdges())
                    queue.push(e.getDestinationNode());

                //Execute the operation and check
                //whether or not we need to continue
                if(!markOperation.test(node))
                    return;
            }
        }
    }
}
