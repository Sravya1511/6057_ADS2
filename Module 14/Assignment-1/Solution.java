import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] words = loadWords();
		//Your code goes here...
		Scanner input = new Scanner(System.in);
		TST<Integer> tst = new TST();
		int value = 0;
		for(int i = 0; i<words.length; i++) {
			for(int j = 0; j<words[i].length(); j++) {
				tst.put(words[i].substring(j), value);
				value++;
			}
		}
		String word = input.nextLine();
		for(String str : tst.keysWithPrefix(word)) {
			System.out.println(str);
		}


	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}