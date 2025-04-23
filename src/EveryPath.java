import java.util.*;

public class EveryPath {
    static class Edge {
        char to;
        int weight;
        Edge(char to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void findPaths(Map<Character, List<Edge>> graph, char u, char w, int targetLength) {
        List<Character> path = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        dfs(graph, u, w, targetLength, 0, path, visited, graph);
    }

    private static void dfs(Map<Character, List<Edge>> graph, char current, char w, int targetLength, int currentLength, List<Character> path, Set<Character> visited, Map<Character, List<Edge>> g) {
        path.add(current);
        visited.add(current);

        if (current == w && currentLength == targetLength) {
            System.out.println(path);
        } else if (currentLength < targetLength) {
            if (g.containsKey(current)) {
                List<Edge> edges = g.get(current);
                for (Edge edge : edges) {
                    if (!visited.contains(edge.to)) {
                        dfs(graph, edge.to, w, targetLength, currentLength + edge.weight, path, visited, g);
                    }
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Character, List<Edge>> graph = new HashMap<>();

        // Example Graph: Add edges
        addEdge(graph, 'A', 'B', 3);
        addEdge(graph, 'A', 'C', 4);
        addEdge(graph, 'B', 'D', 2);
        addEdge(graph, 'C', 'D', 3);
        addEdge(graph, 'D', 'E', 2);
        addEdge(graph, 'B', 'E', 4);

        char u = 'A'; // start vertex
        char w = 'E'; // end vertex

        findPaths(graph, u, w, 7);

    }

    private static void addEdge(Map<Character, List<Edge>> graph, char from, char to, int weight) {
        if (!graph.containsKey(from)) {
            graph.put(from, new ArrayList<Edge>());
        }
        graph.get(from).add(new Edge(to, weight));
    }
}
