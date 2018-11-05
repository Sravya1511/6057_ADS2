import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int vertices = Integer.parseInt(input.nextLine());
		int edges = Integer.parseInt(input.nextLine());
		String[] tokens = input.nextLine().split(" ");

		EdgeWeightedGraph edgeW = new EdgeWeightedGraph(vertices);

		Edge edge = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
		edgeW.addEdge(edge);
		KruskalMST kmst = new KruskalMST(edgeW);
		System.out.println(kmst.weight());





	}
}