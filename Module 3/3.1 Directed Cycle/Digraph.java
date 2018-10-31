/**
 * Class for digraph.
 */
public class Digraph {

    /**
     * number of vertices.
     */
    private final int vertex;
    /**
     * Number of edges
     */
    private int edge;
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
     * @param      vertex     { vertices of int type }
     */
    public Digraph(final int vertex) {
        this.vertex = vertex;
        this.edge = 0;
        indegree = new int[vertex];
        adj = (Bag<Integer>[]) new Bag[vertex];
        for (int v = 0; v < vertex; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Number of vertices.
     *
     * @return     { integer }
     */

    public int vertex() {
        return vertex;
    }
    /**
     * Number of edges.
     *
     * @return     { int }
     */

    public int edge() {
        return edge;
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
        edge++;
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