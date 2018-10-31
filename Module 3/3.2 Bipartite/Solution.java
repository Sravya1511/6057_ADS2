import java.util.Scanner;
/**
 * Class for bipartite.
 */
class Bipartite {
    /**
     * bipartite array.
     */
    private boolean isBipartite;
    /**
     * color array.
     */
    private boolean[] color;
    /**
     * visited or not array.
     */
    private boolean[] marked;
    /**
     * edges array.
     */
    private int[] edgeTo;
    /**
     * stack - cycle.
     */
    private Stack<Integer> cycle;

    /**
     * Constructs the object.
     *
     * @param      G     { Graph class }
     */
    Bipartite(final GraphClass G) {
        isBipartite = true;
        color  = new boolean[G.vertex()];
        marked = new boolean[G.vertex()];
        edgeTo = new int[G.vertex()];

        for (int v = 0; v < G.vertex(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }
    /**
     * depth first search.
     *
     * @param      graph    { Graph class}
     * @param      v     { Source  }
     */

    private void dfs(final GraphClass graph, final int v) {
        marked[v] = true;
        for (int w : graph.adj[v]) {

            if (cycle != null) {
                return;
            }

            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }

    /**
     * Determines if bipartite.
     *
     * @return     True if bipartite, False otherwise.
     */
    public boolean isBipartite() {
        return isBipartite;
    }
}
/**
 * class for Solution.
 */

final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads input.
     * creates object for graph class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int vertices = Integer.parseInt(input.nextLine());
        int edges = Integer.parseInt(input.nextLine());
        GraphClass graph = new GraphClass(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = input.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]));
        }

        Bipartite bi = new Bipartite(graph);
        if (bi.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}