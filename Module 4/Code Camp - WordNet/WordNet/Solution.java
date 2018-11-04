import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;





class Solution {
	private Solution() {
	}
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			String x = input.nextLine();
			HashMap<Integer, String[]> synset = new HashMap<Integer, String[]>();
			HashMap<String, ArrayList<Integer>> synsetQueries = new HashMap<String, ArrayList<Integer>>();

			try {
			    Scanner scanner = new Scanner(new File("Files/" + x));
                while(scanner.hasNextLine()) {
            	   //  // System.out.println(scanner.nextLine());
                   String[] tokens = scanner.nextLine().split(",");
                   String[] words = tokens[1].split(" ");
                   synset.put(Integer.parseInt(tokens[0]), words);
                   // System.out.println(tokens[0]+"----"+Arrays.toString(words));

                }
                for(int i: synset.keySet()) {
                	String[] keys = synset.get(i);
                	for(int j = 0; j<keys.length; j++) {
                		if(synsetQueries.containsKey(keys[j])) {
                			ArrayList<Integer> intarr = synsetQueries.get(keys[j]);
                			intarr.add(i);
                			synsetQueries.put(keys[j], intarr);
                		}
                		else {
                			ArrayList<Integer> indx = new ArrayList<Integer>();
                			indx.add(i);
                			synsetQueries.put(keys[j], indx);

                		}

                	}
                	// System.out.println(i+"----"+Arrays.toString(synset.get(i)));

                }
                // System.out.println(synset);
                // System.out.println(synsetQueries);
            } catch (FileNotFoundException e) {
		    }
			String y = input.nextLine();
			Digraph digraph = new Digraph(synset.size());

		    try {
			    Scanner scanner1 = new Scanner(new File("Files/" + y));
                while(scanner1.hasNextLine()) {
            	    String[] vertices = scanner1.nextLine().split(",");
            	    for(int i = 1; i<vertices.length; i++) {
                        digraph.addEdge(Integer.parseInt(vertices[0]),
            	    	Integer.parseInt(vertices[i]));
            	    }

                }
            } catch (FileNotFoundException e) {
		    }
            String s = input.nextLine();
            DirectedCycle directedCycle = new DirectedCycle(digraph);
                switch (s) {
                	case "Graph":
                	if(directedCycle.hasCycle()) {
                			// throw new IllegalArgumentException("IllegalArgumentException");
                		System.out.println("Cycle detected");
                		    	return;
                		    }
                    if(digraph.checkMultiple()) {
                    	System.out.println("Multiple roots");
                    	return;
                    }
                	System.out.println(digraph);
                	case "Queries":
                	while(input.hasNext()) {
                		String[] tokens = input.nextLine().split(" ");
                		try {
                			if(tokens[0].equals("null")) {
                			System.out.println("IllegalArgumentException");
                			return;
                		    }
                		} catch (IllegalArgumentException e) {
                			System.out.println(e.getMessage());
                		}
                		SAP sap = new SAP(digraph);
                		sap.length(synsetQueries.get(tokens[0]), synsetQueries.get(tokens[1]), synset);


                		}

                	}
		}
	}
