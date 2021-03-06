import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads input.
     * The time complxity is O(E+V).
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
            double distance = dijkstras.
            distance(Integer.parseInt(sd[1]));
            if (distance == 0) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(distance);
            }
            break;

        case "ViaPaths":

            // First is the source and second is the via.
            //  is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] svd = input.nextLine().split(" ");
            DijkstrasSP  dijkstrasVia = new
            DijkstrasSP(edgeWG,
                Integer.parseInt(svd[0]));
            double d1 = dijkstrasVia.
            distance(Integer.parseInt(svd[1]));
            DijkstrasSP  dijkstrasVia2 = new DijkstrasSP(edgeWG,
                Integer.parseInt(svd[1]));
            double d2 = dijkstrasVia2.
            distance(Integer.parseInt(svd[2]));
            double d = d1 + d2;
            if (d == 0 || d1 == 0 || d2 == 0) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(d);
                StringBuilder s = new StringBuilder();
                s.append(dijkstrasVia2.path());
                s.append(dijkstrasVia.path());
                s.append(svd[0]);
                s.reverse();
                System.out.println(s);
            }
            break;
        default:
            break;
        }
    }
    }
}
