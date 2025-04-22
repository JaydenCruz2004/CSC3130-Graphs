public class DirectedorUndirected {

    public static void checkGraphType ( int[][] matrix){
        int n = matrix.length;
        boolean isDirected = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isDirected = true;
                    break;
                }
            }
            if (isDirected) break;
        }

        if (isDirected) {
            System.out.println("The graph is directed.\n");
        } else {
            System.out.println("The graph is undirected.\n");
        }
    }
}

