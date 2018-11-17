import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;


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
     * main method.
     *
     * @param      args  The arguments
     */

	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		    default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();

		// your code goes here
		try {
			Scanner scan = new Scanner(new File(file));
			while (scan.hasNextLine()) {
				String a = scan.nextLine();
				String[] tokens = a.split(" ");
				for (int i = 0; i < tokens.length; i++) {
					st.put(tokens[i].toLowerCase(), 1);
				}
			}
		} catch (FileNotFoundException e) {

		}
	    return st;
	}

}
/**
 * Class for t 9.
 */

class T9 {
	/**
	 * tries.
	 */
	TST<Integer> tst = new TST();
	/**
	 * inserts words into tst.
	 *
	 * @param      st    { parameter_description }
	 */
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		for (String s : st.keys()) {
			// System.out.println(s+"  "+st.get(s));
			if (s.length() == 0) {
				continue;
			}
			tst.put(s, st.get(s));
		}
	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here
		Queue<String> queue = new Queue<String>();
		for (String str : tst.keysWithPrefix(prefix)) {
			// System.out.println(str);
            queue.enqueue(str);
        }
		return queue;
	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here

		return null;
	}

	// return all possibilities(words), find top k with highest frequency.

	public Iterable<String> getSuggestions(final Iterable<String> words, final int k) {
		// your code goes here
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		Insertion insert = new Insertion();
		Queue<String> queue = new Queue<String>();
        int i = 0;
        int count = 0;
        for (String s : words) {
        	count++;
        }
        int[] array = new int[count];

		for (String s : words) {
			array[i] = tst.get(s);
			// System.out.println();
			hashmap.put(tst.get(s), s);
			i++;
		}

		insert.insertionSort(array, count);

		for (int j= 0; j < k; j++) {

			queue.enqueue(hashmap.get(array[j]));
		}

		return queue;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(final String t9Signature, final int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
