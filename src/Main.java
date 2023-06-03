import java.util.*;
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();  // testing;
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        graph.addEdge(vertexA, vertexB, 5);
        graph.addEdge(vertexA, vertexC, 3);
        graph.addEdge(vertexB, vertexD, 2);
        graph.addEdge(vertexC, vertexD, 1);
        graph.addEdge(vertexD, vertexE, 4);

        BFS<String> bfs = new BFS<>(graph, vertexA);
        List<Vertex<String>> bfsPath = bfs.getPath(vertexE);
        System.out.println("BFS Path: " + bfsPath);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, vertexA);
        List<Vertex<String>> dijkstraPath = dijkstra.getPath(vertexE);

        System.out.println("Dijkstra path: " + dijkstraPath);
    }
}