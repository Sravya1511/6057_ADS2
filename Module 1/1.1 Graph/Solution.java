import java.util.Scanner;
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    // public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}
/**
 * Class for graph class.
 */

class GraphClass implements Graph {
	/**
	 * number of vertices.
	 */
	private int V;
	/**
	 * number of edges.
	 */
	private int E;
	/**
	 * adj array of bag class type.
	 */
	private Bag<Integer>[] adj;

	/**
	 * Gets the e.
	 *
	 * @return     The e of int type.
	 */

	public int getE() {
        return E;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      V     { number of vertices }
	 */

	public GraphClass(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
	}
	/**
	 * number of integers.
	 *
	 * @return     { int }
	 */

	public int V() {
        return V;
    }

    /**
     * number of vertices.
     *
     * @return     { int }
     */

    public int E() {
        return E;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { vertex }
     * @param      w     { edge }
     */

    public void addEdge(int v, int w) {
    	if(v == w) {
    		return;
    	}
    	if (!hasEdge(v, w)) {
    		E++;
    	}

        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * determines if vertices are connected or not.
     *
     * @param      v     { vertex. }
     * @param      w     { edge }
     *
     * @return     True if has edge, False otherwise.
     */

    public boolean hasEdge(int v, int w) {
    	if(adj[v].contains(w)) {
    		return true;
    	} else {
    	    return false;
    	}
    }
    /**
     * prints the list of cities connected to other cities.
     *
     * @param      cities  The cities
     *
     * @return     { description_of_the_return_value }
     */

    public String printList(String[] cities) {
        StringBuilder s = new StringBuilder();
            for (int v = 0; v < V; v++) {
            s.append(cities[v] + ": ");
            for (int w : adj[v]) {
                s.append(cities[w] + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
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
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		String api = input.nextLine();
		int vertex = Integer.parseInt(input.nextLine());
		// System.out.println(vertex);
		int edge = Integer.parseInt(input.nextLine());
		// System.out.println();
		String[] cities = input.nextLine().split(",");
		GraphClass gc = new GraphClass(vertex);
		// System.out.println(gc);
		for (int i = 0; i < edge; i++) {
			String[] tokens = input.nextLine().split(" ");
			gc.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		System.out.println(vertex + " vertices, " + gc.getE() + " edges");

		if (edge == 0 || edge == 1 || vertex == 1) {
			System.out.println("No edges");
			return;
		}
		switch(api) {
			case "Matrix":
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < vertex; j++) {
					if (gc.hasEdge(i, j)) {
					    System.out.print("1 ");
					} else {
						System.out.print("0 ");
					}
				}
				if(i != vertex-1)
				System.out.println();
			}
			break;
			case "List":
		    System.out.println(gc.printList(cities));
		    break;
		    default:
		    break;
		}
	}
}