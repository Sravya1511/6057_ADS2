import java.util.Scanner;
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    // public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}

class GraphClass implements Graph {
	private int V;
	private int E;
	private Bag<Integer>[] adj;

	public GraphClass(int V, int E) {
		this.V = V;
		this.E = E;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
	}

	public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public boolean hasEdge(int v, int w) {
    	if(adj[v].contains(w))
    		return true;
    	return false;
    }

}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String api = input.nextLine();
		int vertex = Integer.parseInt(input.nextLine());
		int edge = Integer.parseInt(input.nextLine());
		String[] cities = input.nextLine().split(",");
		GraphClass gc = new GraphClass(vertex, edge);
		for(int i = 0; i<edge; i++) {
			String[] tokens = input.nextLine().split(" ");
			gc.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		switch(api) {
			case "Matrix":
			System.out.println(vertex+" vertices, "+edge+" edges");
			for(int i = 0; i<vertex; i++) {
				for(int j = 0; j<edge; j++) {
					if(gc.hasEdge(i, j)) {
						System.out.print("1 ");


					}
					else {
						    System.out.print("0 ");

					    // else {
					    // 	System.out.print("0");
					    // }
					}
				}
				if(i != vertex-1)
				System.out.println();
			}



		}

	}
}