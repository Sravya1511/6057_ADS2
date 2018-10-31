class Digraph {
	private final int V;
	private int E;
	Bag<Integer>[] adj;
	private int[] indegree;


    public Digraph(int V) {
        // if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
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
        // validateVertex(v);
        // validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public int outdegree(int v) {
        // validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        // validateVertex(v);
        return indegree[v];
    }
}