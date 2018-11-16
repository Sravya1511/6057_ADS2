import java.util.HashSet;

public class BoggleSolver {
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	// Bag<String> bag =  new Bag<String>();
	HashSet<String> bag = new HashSet<String>();
	TrieST triesST = new TrieST();

	public BoggleSolver(String[] dictionary) {
		int j = 0;
		for(int i = 0; i<dictionary.length; i++) {
			triesST.put(dictionary[i], j);
			j++;
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		int count = 0;
		for(int i = 0; i<board.rows(); i++) {
			for(int j = 0; j<board.cols(); j++)  {
				boolean[][] marked = new boolean[board.rows()][board.cols()];
				validwords(board, i, j, "", marked);
				count++;
			}
		}
		// for(String g : bag) {
		// 	System.out.println(g);
		// }
		// System.out.println(count);
		return bag;
	}

	public void validwords(BoggleBoard board, int i, int j, String word, boolean[][] marked) {
		if(marked[i][j]) {
			return;
		}
		if(!triesST.hasPrefix(word)) {
			return;
		}
		// if(word == "") {
		    char a = board.getLetter(i, j);

		    if(a == 'Q') {
		    	word += "QU";
		    }
		    else {
		    	word += a;
		    }
		// }
		if(word.length() > 2 && triesST.contains(word)) {
			bag.add(word);
		}
	    marked[i][j] = true;
		for(int di = -1; di<=1; di++) {
			for(int dj = -1; dj<=1; dj++) {
				int m = i+di;
				int n = j+dj;
				// if(di != 0 && dj != 0 ) {
					// System.out.println(m);
					// System.out.println(n);
					if(n >= 0 && n < board.cols() && m >= 0 && m <board.rows()) {
						// word += board.getLetter(m, n);
						// System.out.println();
						validwords(board, m, n, word, marked);
					}
				// }
				// if((di == 0 && dj == 0) || m <0 || n < 0 || m >= board.rows() || n>= board.cols()) {
				// 	continue;
				// }
				// validwords(board, m, n, word, marked);
			}
		}
		marked[i][j] = false;
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if(!triesST.contains(word)) {
			return 0;
		}
		int len = word.length();
		if(len <= 2) {
			return 0;
		} else if(len <= 4) {
			return 1;
		} else if(len == 5) {
			return 2;
		} else if(len == 6) {
			return 3;
		} else if(len == 7) {
			return 5;
		} else {
			return 11;
		}
	}
}


