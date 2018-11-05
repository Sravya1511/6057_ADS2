import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
/**
 * Class for sap.
 */
public class SAP {
    /**
     * digraph.
     */

    Digraph graph;

    /**
     * Constructs the object.
     *
     * @param      graph  The graph
     */
    public SAP(Digraph graph) {
        this.graph = graph;

    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public void length(ArrayList<Integer> vertex1,
        ArrayList<Integer> vertex2,
        HashMap<Integer, String[]> synset) {
        int distance = 0;
        int m = Integer.MAX_VALUE;
        String[] a = null;
        for (int i = 0; i < vertex1.size(); i++) {
            for (int j = 0; j < vertex2.size(); j++) {
                BreadthFirstPaths bfsVer1 =
                new BreadthFirstPaths(graph, vertex1.get(i));
                BreadthFirstPaths bfsVer2 =
                new BreadthFirstPaths(graph, vertex2.get(j));
                for (int k = 0; k < graph.V(); k++) {
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