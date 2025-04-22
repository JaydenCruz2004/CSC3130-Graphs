public class Main {

    public static void main(String[] args) {
        System.out.println("Problem 4 (code) Directed or undirected:");
        // Test 1: Undirected Graph
        int[][] matrix1 = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        DirectedorUndirected.checkGraphType(matrix1);

        // Test 2: Directed Graph
        int[][] matrix2 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        DirectedorUndirected.checkGraphType(matrix2);
    }
}