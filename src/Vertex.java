import java.util.*;

public class Vertex<V> {
    private V data; // The value associated with the vertex
    private Map<Vertex<V>, Double> adjacentVertices; // Map of adjacent vertices and their edge weights

    //Constructs a new vertex with the given data.

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    //Adds an adjacent vertex with the specified edge weight to this vertex.

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    //Returns the data associated with this vertex.

    public V getData() {
        return data;
    }

    //Returns the map of adjacent vertices and their corresponding edge weights.
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}


