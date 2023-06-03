import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distances;
    private Map<Vertex<V>, Vertex<V>> parent;

    // Constructor to initialize Dijkstra search algorithm
    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
        distances = new HashMap<>();
        parent = new HashMap<>();
        dijkstraSearch();
    }

    // Method to perform Dijkstra's algorithm
    private void dijkstraSearch() {
        // Create a priority queue to store vertices based on their distances
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Set the distance of the start vertex to 0 and add it to the priority queue
        distances.put(startVertex, 0.0);
        priorityQueue.offer(startVertex);

        while (!priorityQueue.isEmpty()) {
            // Get the vertex with the smallest distance from the priority queue
            Vertex<V> currentVertex = priorityQueue.poll();

            // Get the list of edges connected to the current vertex
            List<Edge<V>> edges = graph.getEdges(currentVertex);

            for (Edge<V> edge : edges) {
                // Get the destination vertex and the weight of the edge
                Vertex<V> destination = edge.getDest();
                double weight = edge.getWeight();

                // Calculate the new distance from the start vertex to the destination vertex
                double newDistance = distances.get(currentVertex) + weight;

                // If the new distance is smaller than the current distance, update the distance and parent
                if (!distances.containsKey(destination) || newDistance < distances.get(destination)) {
                    distances.put(destination, newDistance);
                    parent.put(destination, currentVertex);

                    // Add the destination vertex to the priority queue for further exploration
                    priorityQueue.offer(destination);
                }
            }
        }
    }

    // Method to retrieve the shortest path from the start vertex to a target vertex
    public List<Vertex<V>> getPath(Vertex<V> targetVertex) {
        // Create a list to store the vertices in the shortest path
        List<Vertex<V>> path = new ArrayList<>();

        // Start from the target vertex and traverse back to the start vertex using the parent map
        Vertex<V> currentVertex = targetVertex;
        while (currentVertex != null) {
            path.add(currentVertex);
            currentVertex = parent.get(currentVertex);
        }

        // Reverse the order of vertices to obtain the correct path from start to target
        Collections.reverse(path);
        return path;
    }
}

