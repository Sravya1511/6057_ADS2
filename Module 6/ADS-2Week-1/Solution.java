import java.util.Scanner;
import java.util.Arrays;

class PageRank {
	Digraph digraph;
	int vertices;
	double[] prValues;
	int[] outlinks;
    // Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v



	PageRank(Digraph digraph, int vertices) {
		this.digraph = digraph;
		this.vertices = vertices;
		prValues = new double[vertices];
	    outlinks = new int[vertices];
        // adj = (Bag<Integer>[]) new Bag[vertices];


	}

	public void initializePR(String[] incoming) {
        for(int i = 0; i<vertices; i++) {
        	outlinks[i] = digraph.outdegree(i);
        	prValues[i] = 1.0/4;
        }
    // System.out.println(Arrays.toString(outlinks));
    // System.out.println(Arrays.toString(incoming));
    // System.out.println(Arrays.toString(prValues));




	}

	public void calculatePR() {
         for(int i = 0; i<1000; i++) {

        }
	}

	public String toString()  {
		StringBuilder s = new StringBuilder();

		for(int i = 0; i<vertices; i++) {
			s.append(i+": "+prValues[i]+"\n");
		}
		return s.toString();
	}



}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices

		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph


		// Create page rank object and pass the graph object to the constructor

        Scanner input  = new Scanner(System.in);
        int vertices = Integer.parseInt(input.nextLine());
        Digraph digraph = new Digraph(vertices);
        String[] incoming = new String[vertices];

        for(int j = 0; j<vertices; j++) {
        	// System.out.println(vertices);
        	String a = input.nextLine();
        	incoming[j] = a;
        	String [] tokens = a.split(" ");
        	for(int i = 1; i<tokens.length; i++) {
                digraph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[i]));
        	}
        }

        System.out.println(digraph);
        // System.out.println();
        PageRank page = new PageRank(digraph, vertices);
        page.initializePR(incoming);
        System.out.println(page);


		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
