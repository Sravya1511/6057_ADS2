import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
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
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner input = new Scanner(System.in);
		int vertices = Integer.parseInt(input.nextLine());
		int edges = Integer.parseInt(input.nextLine());
		EdgeWeightedGraph edgeWG = new EdgeWeightedGraph(vertices);
		for (int i = 0; i < edges; i++) {
		    String[] tokens = input.nextLine().split(" ");
		    Edge edge = new Edge(Integer.parseInt(tokens[0]),
		    	Integer.parseInt(tokens[1]),
		    	Double.parseDouble(tokens[2]));
		    edgeWG.addEdge(edge);
		}


        while (input.hasNext()) {
        String caseToGo = input.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
		    System.out.println(edgeWG);
			break;
		case "DirectedPaths":
			// Handle the case of DirectedPaths,.
			//  where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] sd = input.nextLine().split(" ");
			DijkstrasSP  dijkstras = new DijkstrasSP(edgeWG,
				Integer.parseInt(sd[0]));
			double distance = dijkstras.distance(Integer.parseInt(sd[1]));
			if (distance == 0) {
				System.out.println("No Path Found.");
			} else {
				System.out.println(distance);
			}
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via.
			//  is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] svd = input.nextLine().split(" ");
			DijkstrasSP  dijkstrasVia = new DijkstrasSP(edgeWG,
				Integer.parseInt(svd[0]));
			double d = dijkstrasVia.distance(Integer.parseInt(svd[2]),
				Integer.parseInt(svd[1]));
			if(d == 0) {
				System.out.println("No Path Found.");
			} else {
				System.out.println(d);
			}
			break;
		default:
			break;
        }
    }
	}
}