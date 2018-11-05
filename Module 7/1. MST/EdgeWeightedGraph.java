public class EdgeWeightedGraph {
    /**
     * line separator.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * vertices.
     *
     */

    private final int V;
    /**
     * edges.
     */
    private int E;
    /**
     * bags class of edge type.
     */
    private Bag<Edge>[] adj;

    /**
     * Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(int vertex) {

        this.V = vertex;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[vertex];
        for (int v = 0; v < vertex; v++) {
            adj[v] = new Bag<Edge>();
        }
    }




    /**
     * Returns the number of vertices.
     *  in this edge-weighted graph.
     *
     * @return the number of vertices.
     *  in this edge-weighted graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges.
     *  in this edge-weighted graph.
     *
     * @return the number of edges.
     *  in this edge-weighted graph
     */
    public int E() {
        return E;
    }



    /**
     * Adds an edge.
     *
     * @param      e     { Edge }
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        // validateVertex(v);
        // validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * iterable.
     *
     * @param      v     { vertex }
     *
     * @return     { iterable }
     */
    public Iterable<Edge> adj(int v) {
        // validateVertex(v);
        return adj[v];
    }

    /**
     * degree.
     *
     * @param      v     { v }
     *
     * @return     { int }
     */
    public int degree(int v) {
        // validateVertex(v);
        return adj[v].size();
    }

    /**
     * iterable.
     *
     * @return     { edges }
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}