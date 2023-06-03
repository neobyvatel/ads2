import java.util.*;

// The BFS performs a breadth-first search algorithm on a weighted graph. extends Search

public class BFS<V> extends Search<V> {
    private Map<Vertex<V>, Boolean> visited;
    private Map<Vertex<V>, Vertex<V>> parent;

    //Constructs a new BFS object with the given graph and start vertex.

    public BFS(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
        visited = new HashMap<>();
        parent = new HashMap<>();
        breadthFirstSearch();
    }

    //Performs the bfs algorithm on the graph from the start vertex.

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

    /**
     * Returns the path from the start vertex to the target vertex as a list of vertices.
     * The path is determined using the parent map.
     *
     * targetVertex  the target vertex to reach
     * return the path from the start vertex to the target vertex
     */
    public List<Vertex<V>> getPath(Vertex<V> targetVertex) {
        List<Vertex<V>> path = new ArrayList<>();
        Vertex<V> currentVertex = targetVertex;

        while (currentVertex != null) {
            path.add(currentVertex);
            currentVertex = parent.get(currentVertex);
        }

        Collections.reverse(path);
        return path;
    }
}

