import java.util.*;

public class WeightedGraph<V> {
    // Map to store the vertices and their associated edges
    private Map<Vertex<V>, List<Edge<V>>> map;

    // Constructor to initialize the graph
    public WeightedGraph() {
        this.map = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(Vertex<V> vertex) {
        // Initialize an empty list of edges for the vertex
        map.put(vertex, new ArrayList<>());
    }

    // Method to add an edge between two vertices in the graph
    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        // Create a new edge with the given source, destination, and weight
        Edge<V> edge = new Edge<>(source, dest, weight);

        // Retrieve the list of edges for the source vertex and add the new edge
        map.get(source).add(edge);
    }

    // Method to retrieve the list of edges connected to a given vertex
    public List<Edge<V>> getEdges(Vertex<V> vertex) {
        // Return the list of edges associated with the vertex
        return map.get(vertex);
    }
}

