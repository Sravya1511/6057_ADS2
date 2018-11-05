
/**
 * Class for breadth first paths.
 */
class BreadthFirstPaths {
    /**
     * maximu integer value.
     */
    private static final int INFINITY = Integer.MAX_VALUE;
    /**
     * marked array.
     */
    private boolean[] marked;
      // marked[v] = is there an s-v path
    /**
     * edge to array.
     */
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    /**
     * distance array.
     */
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path

    /**
     * computes shortest path.
     *
     * @param      digraph    { Digraph }
     * @param      s     { souce vertex }
     */
    public BreadthFirstPaths(final Digraph digraph, final int s) {
        marked = new boolean[digraph.V()];
        distTo = new int[digraph.V()];
        edgeTo = new int[digraph.V()];
        // validateVertex(s);
        bfs(digraph, s);
    }
    /**
     * bfs traversal.
     *
     * @param      gra    { digraph}
     * @param      s     { source }
     */

    private void bfs(final Digraph gra, final int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < gra.V(); v++) {
            distTo[v] = INFINITY;
        }
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : gra.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    /**
     * Determines if it has path to.
     *
     * @param      v     { vertex in graph }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        // validateVertex(v);
        return marked[v];
    }

    /**
     * distance to vertex v.
     *
     * @param      v     { vertex in graph }
     *
     * @return     { returns distance }
     */
    public int distTo(final int v) {
        // validateVertex(v);
        return distTo[v];
    }
}
