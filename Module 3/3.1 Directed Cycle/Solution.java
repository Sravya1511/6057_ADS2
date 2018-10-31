import java.util.Scanner;
class DirectedCycle {
    private boolean[] marked;        // marked[v] = has vertex v been marked?
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle == null) dfs(G, v);
    }

     private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj[v]) {

            // short circuit if directed cycle found
            if (cycle != null) return;

            // found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                // assert check();
            }
        }
        onStack[v] = false;
    }

     public boolean hasCycle() {
        return cycle != null;
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int vertices = Integer.parseInt(input.nextLine());
		int edges = Integer.parseInt(input.nextLine());
		Digraph dg = new Digraph(vertices);
		for(int i = 0; i<edges; i++) {
			String[] tokens = input.nextLine().split(" ");
			dg.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[0]));
		}

		DirectedCycle dc = new DirectedCycle(dg);
		if(dc.hasCycle()) System.out.println("Cycle doesn't exists.");
		else System.out.println("Cycle exists.");

	}
}


