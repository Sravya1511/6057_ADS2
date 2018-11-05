/**
 * Class for directed cycle.
 */
class DirectedCycle {
    /**
     * marked boolean array.
     */
    private boolean[] marked;
    /**
     * edgeTo array.
     */
    private int[] edgeTo;
    /**
     * boolean array.
     */
    private boolean[] onStack;
    /**
     * cycle  - stack.
     */
    private Stack<Integer> cycle;
     /**
      * Constructs the object.
      *
      * @param      diaGraph     { Digraph }
      */

    DirectedCycle(final Digraph diaGraph) {
        marked  = new boolean[diaGraph.vertex()];
        onStack = new boolean[diaGraph.vertex()];
        edgeTo  = new int[diaGraph.vertex()];
        for (int v = 0; v < diaGraph.vertex(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(diaGraph, v);
            }
        }
    }

    /**
     * creates dfs and fills marked array and edgeto array.
     * Thhe time complexity is O(E).
     *
     *
     * @param      diaGraph     { digraph }
     * @param      v     { source vertex }
     */
    private void dfs(final Digraph diaGraph, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : diaGraph.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(diaGraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                // assert check();
            }
        }
        onStack[v] = false;
    }

    /**
     * Determines if it has cycle.
     * Thhe time complexity is O(1).
     *
     *
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }
}
