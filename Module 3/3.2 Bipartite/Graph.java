

/**
 * Class for graph class.
 */

class GraphClass {
    /**
     * number of vertices.
     */
    private int vertex;
    /**
     * number of edges.
     */
    private int edge;
    /**
     * adj array of bag class type.
     */
    Bag<Integer>[] adj;

    /**
     * Gets the e.
     * The time complexity is O(1).
     *
     * @return     The e of int type.
     */

    public int getedge() {
        return edge;
    }

    public Bag<Integer> getAdj(int i) {
        return adj[i];
    }
    /**
     * Constructs the object.
     * The time complexity is O(N).
     *
     *
     * @param      vertex1     { number of vertices }
     */

    GraphClass(final int vertex1) {
        this.vertex = vertex1;
        adj = (Bag<Integer>[]) new Bag[vertex1];
        for (int v = 0; v < vertex1; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * number of integers.
     * The time complexity is O(1).
     *
     *
     * @return     { int }
     */

    public int vertex() {
        return vertex;
    }

    /**
     * number of vertices.
     * The time complexity is O(1).
     *
     *
     * @return     { int }
     */

    public int edge() {
        return edge;
    }
    /**
     * Adds an edge.
     * The time complexity is O(N).
     *
     *
     * @param      v     { vertex }
     * @param      w     { edge }
     */

    public void addEdge(final int v, final int w) {
        if (v == w) {
            return;
        }
        if (!hasedgedge(v, w)) {
            edge++;
        }

        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * determines if vertices are connected or not.
     * The time complexity is O(N).
     *
     *
     * @param      v     { vertex. }
     * @param      w     { edge }
     *
     * @return     True if has edge, False otherwise.
     */

    public boolean hasedgedge(final int v, final int w) {
        if (adj[v].contains(w)) {
            return true;
        }
        return false;

    }
    /**
     * prints the list of cities connected to other cities.
     * The time complexity is O(N^2).
     *
     *
     * @param      cities  The cities
     *
     * @return     { description_of_the_return_value }
     */

    public String printList(final String[] cities) {
        StringBuilder s = new StringBuilder();
            for (int v = 0; v < vertex; v++) {
            s.append(cities[v] + ": ");
            for (int w : adj[v]) {
                s.append(cities[w] + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

     public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
}