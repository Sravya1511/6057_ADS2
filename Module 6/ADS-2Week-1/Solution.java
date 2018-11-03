import java.util.Scanner;
class PageRank {

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

        for(int j = 0; j<vertices; j++) {
        	// System.out.println(vertices);
        	String [] tokens = input.nextLine().split(" ");
        	for(int i = 1; i<tokens.length; i++) {
                digraph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[i]));
        	}
        }

        System.out.println(digraph);
        System.out.println();


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
