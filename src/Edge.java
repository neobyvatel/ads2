import java.util.*;


public class Edge<V> {
    private Vertex<V> source; // The source vertex of the edge
    private Vertex<V> dest; // The destination vertex of the edge
    private double weight; // The weight of the edge

    // Construct a new edge with the given source, destination, and weight.
    public Edge(Vertex<V> source, Vertex<V> dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    // getters and setters
    public Vertex<V> getSource() {
        return source;
    }



    public Vertex<V> getDest() {
        return dest;
    }


    public double getWeight() {
        return weight;
    }


    public void setSource(Vertex<V> value) {
        this.source = value;
    }


    public void setDest(Vertex<V> value) {
        this.dest = value;
    }


    public void setWeight(double value) {
        this.weight = value;
    }
}


