import java.util.*;

public class Search<V> {
    protected WeightedGraph<V> graph; // The weighted graph to perform the search on
    protected Vertex<V> startVertex; // The starting vertex for the search

    //Constructs a new search object with the given graph and start vertex.

    public Search(WeightedGraph<V> graph, Vertex<V> startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
    }
}



