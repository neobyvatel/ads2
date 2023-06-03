import java.util.*;
public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distances;
    private Map<Vertex<V>, Vertex<V>> parent;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
        distances = new HashMap<>();
        parent = new HashMap<>();
        dijkstraSearch();
    }

    private void dijkstraSearch() {
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        distances.put(startVertex, 0.0);
        priorityQueue.offer(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> currentVertex = priorityQueue.poll();
            List<Edge<V>> edges = graph.getEdges(currentVertex);

            for (Edge<V> edge : edges) {
                Vertex<V> destination = edge.getDest();
                double weight = edge.getWeight();
                double newDistance = distances.get(currentVertex) + weight;

                if (!distances.containsKey(destination) || newDistance < distances.get(destination)) {
                    distances.put(destination, newDistance);
                    parent.put(destination, currentVertex);
                    priorityQueue.offer(destination);
                }
            }
        }
    }

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
