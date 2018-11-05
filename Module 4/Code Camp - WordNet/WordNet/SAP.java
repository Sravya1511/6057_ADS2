import java.util.ArrayList;
import java.util.HashMap;
// import java.util.Arrays;
/**
 * Class for sap.
 */
public class SAP {
    /**
     * digraph.
     */

    private Digraph graph;

    /**
     * Constructs the object.
     *
     * @param      graph1  The graph
     */
    public SAP(final Digraph graph1) {
        this.graph = graph1;

    }
    /**
     * distance.
     * The time complexity is O(V).
     *
     * @param      vertex1  The vertex 1
     * @param      vertex2  The vertex 2
     * @param      synset   The synset
     */

    public void length(final ArrayList<Integer> vertex1,
        final ArrayList<Integer> vertex2,
        final HashMap<Integer, String[]> synset) {
        int distance = 0;
        int m = Integer.MAX_VALUE;
        String[] a = null;
        for (int i = 0; i < vertex1.size(); i++) {
            for (int j = 0; j < vertex2.size(); j++) {
                BreadthFirstPaths bfsVer1 =
                new BreadthFirstPaths(graph, vertex1.get(i));
                BreadthFirstPaths bfsVer2 =
                new BreadthFirstPaths(graph, vertex2.get(j));
                for (int k = 0; k < graph.vertex(); k++) {
                    if (bfsVer1.hasPathTo(k) && bfsVer2.hasPathTo(k)) {
                        distance = bfsVer1.distTo(k) + bfsVer2.distTo(k);
                        // System.out.println(distance);
                        if (distance < m) {
                        m = distance;
                        a = synset.get(k);

                    }
                    }

                }

        }
    }
    StringBuilder ancestor = new StringBuilder();

    for (int i = 0; i < a.length - 1; i++) {
        ancestor.append(a[i]).append(" ");
    }
    ancestor.append(a[a.length - 1]);


    System.out.println("distance = "
        + m + ", ancestor = " + ancestor);

}
}