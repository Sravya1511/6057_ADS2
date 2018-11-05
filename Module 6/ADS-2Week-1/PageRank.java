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
    double[] previousPR;
	double[] outlinks;
    int[] indegreeCount;
    String[] incomingWebPages;
    // Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v



	PageRank(Digraph digraph, int vertices) {
		this.digraph = digraph;
		this.vertices = vertices;

		prValues = new double[vertices];
        previousPR = new double[vertices];
	    outlinks = new double[vertices];
        indegreeCount = new int[vertices];
        incomingWebPages = new String[vertices];
        // adj = (Bag<Integer>[]) new Bag[vertices];


	}
    /**
     * initilalizes initial pr values.
     * The time complexity is O(V).
     *
     * @param      incoming  The incoming
     */

	public void initializePR() {
        for(int i = 0; i<vertices; i++) {
        	outlinks[i] = digraph.outdegree(i);
        	prValues[i] = 1.0/vertices;
            indegreeCount[i] = digraph.indegree(i);
            incomingWebPages[i] = digraph.incomingPages(i);

        }
    // System.out.println(Arrays.toString(outlinks));
    // System.out.println(Arrays.toString(indegreeCount));
    // System.out.println(Arrays.toString(incomingWebPages));
    // System.out.println(Arrays.toString(prValues));
      // String[] tokens = incomingWebPages[2].split("");
      // System.out.println(Arrays.toString(tokens));




	}
    /**
     * Calculates the pr.
     * The time complexity is O(1000*V).
     *
     *
     * @param      incoming  The incoming
     */

	public void calculatePR() {
        Digraph diagraphReverse = new Digraph(digraph.V());
        diagraphReverse = digraph.reverse();
        for(int i = 0; i<vertices; i++) {
            previousPR[i] = prValues[i];
        }
        // System.arraycopy(prValues, 0, previousPR, 0, digraph.V());
        for(int i = 0; i<999; i++) {
        	for(int j = 0; j<vertices; j++) {
        		// // System.out.println(incoming[j]);
          //       String[] tokens = incomingWebPages[j].split("");
          //       // System.out.println(Arrays.toString(tokens));
          //       double a = 0.0;
          //       if(indegreeCount[j] == 0) {
          //       	// System.out.println("hi");
          //       	prValues[j] = 0.0;
          //       }
          //       else {
          //       	for(int k = 0; k<tokens.length; k++) {
          //       	a += prValues[Integer.parseInt(tokens[k])] / outlinks[Integer.parseInt(tokens[k])];
          //           }
          //       prValues[j] = a;

          //       }
                prValues[j] = 0.0;
                 for (Integer w :  diagraphReverse.adj(j)) {
                    prValues[j] += previousPR[w] / outlinks[w];

                }

        	}
              if (Arrays.equals(prValues, previousPR)) {
                break;
            }
            // System.arraycopy(prValues, 0, previousPR, 0, digraph.V());
             for(int a = 0; a<vertices; a++) {
            previousPR[a] = prValues[a];
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

