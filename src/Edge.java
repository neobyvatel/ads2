import java.util.*;


public class Edge<V> {
    private Vertex<V> source;
    private Vertex<V> dest;
    private double weight;

    public Edge(Vertex<V> source, Vertex<V> dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

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

