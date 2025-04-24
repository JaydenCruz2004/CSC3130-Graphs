
import java.util.ArrayList;
import java.util.List;

//https://www.baeldung.com/java-graphs
//https://www.codecademy.com/learn/graph-data-structures-java/modules/graphs-java/cheatsheet

public class DrawGraph {
    public static void main(String[] args) {
        String input = "[ (I, 2), (A, 5), (E, 4), (F, 2), (T, 2), (S, 3) ]";
        List<NodePair> nodes = parseInput(input);
        int n = nodes.size();

        boolean[][] adjMatrix = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            NodePair np = nodes.get(i);
            int x = np.distance;

            int rightIndex = (i + x) % n;
            int leftIndex = (i - x + n) % n;

            adjMatrix[i][rightIndex] = true;
            adjMatrix[i][leftIndex] = true;
        }

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    static class NodePair {
        char vertex;
        int distance;
        NodePair(char vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static List<NodePair> parseInput(String input) {
        List<NodePair> list = new ArrayList<>();
        input = input.replaceAll("[\\[\\]()\\s]", "");
        if (input.isEmpty()) return list;
        String[] parts = input.split(",");

        for (int i = 0; i < parts.length; i += 2) {
            char vertex = parts[i].charAt(0);
            int distance = Integer.parseInt(parts[i + 1]);
            list.add(new NodePair(vertex, distance));
        }
        return list;
    }
}
