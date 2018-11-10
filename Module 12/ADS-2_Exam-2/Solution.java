import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner input = new Scanner(System.in);
		int vertices = Integer.parseInt(input.nextLine());
		int edges = Integer.parseInt(input.nextLine());
		EdgeWeightedGraph edgeWG = new EdgeWeightedGraph(vertices);
		for(int i = 0; i<edges; i++) {
		    String[] tokens = input.nextLine().split(" ");
		    Edge edge = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
		    edgeWG.addEdge(edge);
		}


        while(input.hasNext()) {
        String caseToGo = input.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
		    System.out.println(edgeWG);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;


        }
    }


	}
}