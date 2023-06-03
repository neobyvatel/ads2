import java.util.*;

public class BFS<V> extends Search<V> {
    private Map<Vertex<V>, Boolean> visited;
    private Map<Vertex<V>, Vertex<V>> parent;

    public BFS(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
        visited = new HashMap<>();
        parent = new HashMap<>();
        breadthFirstSearch();
    }

    private void breadthFirstSearch() {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(startVertex);
        visited.put(startVertex, true);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            List<Edge<V>> edges = graph.getEdges(currentVertex);

            for (Edge<V> edge : edges) {
                Vertex<V> destination = edge.getDest();

                if (!visited.containsKey(destination)) {
                    queue.add(destination);
                    visited.put(destination, true);
                    parent.put(destination, currentVertex);
                }
            }
        }
    }
}
