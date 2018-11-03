import java.util.Arrays;
/**
 * Class for page rank.
     * The time complexity is O(V*1000).
 *
 */

class PageRank {
	Digraph digraph;
	int vertices;
	double[] prValues;
	double[] outlinks;
    // Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v



	PageRank(Digraph digraph, int vertices) {
		this.digraph = digraph;
		this.vertices = vertices;
		prValues = new double[vertices];
	    outlinks = new double[vertices];
        // adj = (Bag<Integer>[]) new Bag[vertices];


	}
    /**
     * initilalizes initial pr values.
     * The time complexity is O(V).
     *
     * @param      incoming  The incoming
     */

	public void initializePR(String[] incoming) {
        for(int i = 0; i<vertices; i++) {
        	outlinks[i] = digraph.outdegree(i);
        	prValues[i] = 1.0/4;
        }
    // System.out.println(Arrays.toString(outlinks));
    // System.out.println(Arrays.toString(incoming));
    // System.out.println(Arrays.toString(prValues));




	}
    /**
     * Calculates the pr.
     * The time complexity is O(1000*V).
     *
     *
     * @param      incoming  The incoming
     */

	public void calculatePR(String[] incoming) {
        for(int i = 0; i<1000; i++) {
        	for(int j = 0; j<vertices; j++) {
        		// System.out.println(incoming[j]);
                String[] tokens = incoming[j].split(" ");
                double a = 0;
                if(outlinks[j] == 0) {
                	System.out.println("hi");
                	prValues[j] = 0.0;
                }
                else {
                	for(int k = 1; k<tokens.length; k++) {
                	a += prValues[Integer.parseInt(tokens[k])] / outlinks[Integer.parseInt(tokens[k])];
                    }
                prValues[j] = a;

                }

        	}
        }
	}
    /**
     * Returns a string representation of the object.
     * The time complexity is O(V).
     *
     *
     * @return     String representation of the object.
     */

	public String toString()  {
		StringBuilder s = new StringBuilder();

		for(int i = 0; i<vertices; i++) {
			s.append(i+" - "+prValues[i]+"\n");
		}
		return s.toString();
	}



}

class WebSearch {

}

