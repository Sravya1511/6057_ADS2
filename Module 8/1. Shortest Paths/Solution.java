import java.util.Scanner;
import java.util.HashMap;
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] tokens = input.nextLine().split(" ");
		int vertices = Integer.parseInt(tokens[0]);
		int edges = Integer.parseInt(tokens[1]);
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		String[] cities = input.nextLine().split(" ");
		for(int j = 0; j<vertices; j++) {
              hashmap.put(cities[j], j);
		}
		EdgeWeightedGraph edgeW = new EdgeWeightedGraph(vertices);
		for(int i = 0; i<edges; i++) {
			String[] roots = input.nextLine().split(" ");
		    Edge edge = new Edge(hashmap.get(roots[0]), hashmap.get(roots[1]), Double.parseDouble(roots[2]));
            edgeW.addEdge(edge);
		}
		int queries = Integer.parseInt(input.nextLine());
		for(int i = 0; i<queries; i++) {
			String[] connections = input.nextLine().split(" ");
	        DijkstraSP dik = new DijkstraSP(edgeW, hashmap.get(connections[0]));
            System.out.println((int)dik.distance(hashmap.get(connections[1])));

		}

	}
}