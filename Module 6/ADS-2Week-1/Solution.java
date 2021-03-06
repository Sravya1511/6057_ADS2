import java.util.Scanner;
/**
 * Class for solution.
     * The time complexity is O(V*1000).
 *
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // read the first line of the input to.
        // get the number of vertices.

        // iterate count of vertices times.
        // to read the adjacency list from std input.
        // and build the graph.


        // Create page rank object and pass the graph.
         //object to the constructor.

        Scanner input  = new Scanner(System.in);
        int vertices = Integer.parseInt(input.nextLine());
        Digraph digraph = new Digraph(vertices);

        for (int j = 0; j < vertices; j++) {
            // System.out.println(vertices);
            String a = input.nextLine();
            String[] tokens = a.split(" ");
            for (int i = 1; i < tokens.length; i++) {
                digraph.addEdge(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[i]));
            }
        }

        System.out.println(digraph);
        // System.out.println();
        for (int v = 0; v < vertices; v++) {
            if (digraph.outdegree(v) == 0) {
                for (int w = 0; w < vertices; w++) {
                    if (v != w)  {
                        digraph.addEdge(v, w);
                    }
                }
            }
        }

        PageRank page = new PageRank(digraph, vertices);
        page.initializePR();
        page.calculatePR();

        System.out.println(page);


        // print the page rank object

        // This part is only for the final test case

        // File path to the web content
        String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object and the.
        //  file path to the constructor.

        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky

    }
}

