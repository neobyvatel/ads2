import java.util.*;

public class Search<V> {
    protected WeightedGraph<V> graph;
    protected Vertex<V> startVertex;

    public Search(WeightedGraph<V> graph, Vertex<V> startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
    }
}


