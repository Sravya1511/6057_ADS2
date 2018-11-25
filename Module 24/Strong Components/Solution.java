import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int V = Integer.parseInt(input.nextLine());
        int E = Integer.parseInt(input.nextLine());
        DigraphGenerator digraphGenerator = new DigraphGenerator();
        StdOut.println("complete graph");
        Digraph a = digraphGenerator.complete(V);
        KosarajuSharirSCC scc = new KosarajuSharirSCC(a);
        // number of connected components
        int m = scc.count();
        StdOut.println(m + " strong components");
        StdOut.println(digraphGenerator.complete(V));
        StdOut.println();

        StdOut.println("simple");
        Digraph b = digraphGenerator.simple(V, E);
        KosarajuSharirSCC sccSimple = new KosarajuSharirSCC(b);
        // number of connected components
        int n = sccSimple.count();
        StdOut.println(n + " strong components");
        StdOut.println(digraphGenerator.simple(V, E));
        StdOut.println();

        StdOut.println("path");
        Digraph c = digraphGenerator.path(V);
        KosarajuSharirSCC sccPath = new KosarajuSharirSCC(c);
        // number of connected components
        int o = sccPath.count();
        StdOut.println(o + " strong components");
        StdOut.println(digraphGenerator.path(V));
        StdOut.println();

        StdOut.println("cycle");
        Digraph d = digraphGenerator.cycle(V);
        KosarajuSharirSCC sccCycle = new KosarajuSharirSCC(d);
        // number of connected components
        int p = sccCycle.count();
        StdOut.println(p + " strong components");
        StdOut.println(digraphGenerator.cycle(V));
        StdOut.println();

        StdOut.println("Eulierian path");
        Digraph e = digraphGenerator.eulerianPath(V, E);
        KosarajuSharirSCC sccEuler = new KosarajuSharirSCC(e);
        // number of connected components
        int q = sccEuler.count();
        StdOut.println(q + " strong components");
        StdOut.println(digraphGenerator.eulerianPath(V, E));
        StdOut.println();

        StdOut.println("Eulierian cycle");
        Digraph f = digraphGenerator.eulerianCycle(V, E);
        KosarajuSharirSCC sccEulierianCycle = new KosarajuSharirSCC(f);
        // number of connected components
        int r = sccEulierianCycle.count();
        StdOut.println(r + " strong components");
        StdOut.println(digraphGenerator.eulerianCycle(V, E));
        StdOut.println();

        StdOut.println("binary tree");
        Digraph g = digraphGenerator.binaryTree(V);
        KosarajuSharirSCC sccBinary = new KosarajuSharirSCC(g);
        // number of connected components
        int s = sccBinary.count();
        StdOut.println(s + " strong components");
        StdOut.println(digraphGenerator.binaryTree(V));
        StdOut.println();

        StdOut.println("tournament");
        Digraph  h = digraphGenerator.tournament(V);
        KosarajuSharirSCC sccTournament = new KosarajuSharirSCC(h);
        // number of connected components
        int t = sccTournament.count();
        StdOut.println(t + " strong components");
        StdOut.println(digraphGenerator.tournament(V));
        StdOut.println();

        StdOut.println("DAG");
        Digraph i = digraphGenerator.dag(V, E);
        KosarajuSharirSCC sccDAG = new KosarajuSharirSCC(i);
        // number of connected components
        int u = sccDAG.count();
        StdOut.println(u + " strong components");
        StdOut.println(digraphGenerator.dag(V, E));
        StdOut.println();

        StdOut.println("rooted-in DAG");
        Digraph j = digraphGenerator.rootedInDAG(V, E);
        KosarajuSharirSCC sccRID = new KosarajuSharirSCC(j);
        // number of connected components
        int  v = sccRID.count();
        StdOut.println(v + " strong components");
        StdOut.println(digraphGenerator.rootedInDAG(V, E));
        StdOut.println();

        StdOut.println("rooted-out DAG");
        Digraph k = digraphGenerator.rootedOutDAG(V, E);
        KosarajuSharirSCC sccROD = new KosarajuSharirSCC(k);
        // number of connected components
        int w = sccROD.count();
        StdOut.println(w + " strong components");
        StdOut.println(digraphGenerator.rootedOutDAG(V, E));
        StdOut.println();

        StdOut.println("rooted-in tree");
        Digraph l = digraphGenerator.rootedInTree(V);
        KosarajuSharirSCC sccRIT = new KosarajuSharirSCC(l);
        // number of connected components
        int x = sccRIT.count();
        StdOut.println(x + " strong components");
        StdOut.println(digraphGenerator.rootedInTree(V));
        StdOut.println();

        StdOut.println("rooted-out Tree");
        Digraph y = digraphGenerator.rootedOutTree(V);
        KosarajuSharirSCC sccROT = new KosarajuSharirSCC(y);
        // number of connected components
        int z = sccROT.count();
        StdOut.println(z + " strong components");
        StdOut.println(digraphGenerator.rootedOutTree(V));
        StdOut.println();


	}
}