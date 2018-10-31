/**
 * Class for digraph.
 */
public class Digraph {

    /**
     * number of vertices.
     */
    private final int V;
    /**
     * Number of edges
     */
    private int E;
    /**
     * array of bag class.
     */
    Bag<Integer>[] adj;
    /**
     * number of incoming edges.
     */
    private int[] indegree;
    /**
     * Constructs the object.
     *
     * @param      V     { vertices of int type }
     */
    public Digraph(final int V) {
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Number of vertices.
     *
     * @return     { integer }
     */

    public int V() {
        return V;
    }
    /**
     * Number of edges.
     *
     * @return     { int }
     */

    public int E() {
        return E;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { vertex 1 }
     * @param      w     { vertex 2 }
     */

    public void addEdge(final int v, final int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }
    /**
     * iterable.
     *
     * @param      v     { vertex }
     *
     * @return     { integer of adj list }
     */


    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }

}