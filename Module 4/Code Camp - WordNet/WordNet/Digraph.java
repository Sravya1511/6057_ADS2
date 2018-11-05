
import java.util.NoSuchElementException;
/**
 * Class for digraph.
 */


public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * number of vertices in this digraph.
     */

    private final int V;
    /**
     * number of edges in this digraph.
     */
    private int E;
    /**
     * adj[v] = adjacency list for vertex v.
     */
    private Bag<Integer>[] adj;
    /**
     * indegree[v] = indegree of vertex v.
     */
    private int[] indegree;

    /**
     * Constructs the object.
     *
     * @param      V     { Vertices }
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
     * Constructs the object.
     *
     * @param      G     { Digraph }
     */
    public Digraph(final Digraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < V; v++) {
            this.indegree[v] = G.indegree(v);
        }
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    /**
     * number of vertices.
     *
     * @return     { int }
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
     * @param      v     { node 1 }
     * @param      w     { node 2 }
     */
    public void addEdge(final int v, final int w) {
        // validateVertex(v);
        // validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    /**
     * iterable
     *
     * @param      v     { vertex  }
     *
     * @return     { bag of vertex v }
     */
    public Iterable<Integer> adj(final int v) {
        // validateVertex(v);
        return adj[v];
    }

    /**
     * outdegree of the vertex.
     *
     * @param      v     { vertex v }
     *
     * @return     { int }
     */
    public int outdegree(final int v) {
        // validateVertex(v);
        return adj[v].size();
    }

    /**
     * indegree of the vertex.
     *
     * @param      v     { vertex }
     *
     * @return     { int }
     */
    public int indegree(final int v) {
        // validateVertex(v);
        return indegree[v];
    }

    /**
     * checks if the node is root or not.
     *
     * @return     { true or false }
     */

    public boolean checkMultiple() {
         // Digraph  = new Digraph(V);
        int check = 0;
        for (int v = 0; v < V; v++) {
            // for (int w : adj(v)) {
                if(outdegree(v) == 0) {
                    check++;
                // }
                if(check >1) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * reverses the graph
     *
     * @return     { digraph }
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
