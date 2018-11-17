import java.util.HashMap;
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
     * The time complexity is O(L*log(N)).
     *
     * @param      st    { Binary search symbol table }
     */
    public T9(final BinarySearchST<String, Integer> st) {
        // your code goes here
        for (String s : st.keys()) {
            // System.out.println(s+"  "+st.get(s));
            if (s.length() == 0) {
                continue;
            }
            tst.put(s, st.get(s));
        }
    }

    /**
     * // get all the prefixes that match.
     *  with given prefix.
     *  *The time complexity is O(L*log(N)).

     *
     * @param      prefix  The prefix
     *
     * @return     All words.
     */
    public Iterable<String> getAllWords(final String prefix) {
        // your code goes here
        Queue<String> queue = new Queue<String>();
        for (String str : tst.keysWithPrefix(prefix)) {
            // System.out.println(str);
            queue.enqueue(str);
        }
        return queue;
    }
    /**
     * potential words.
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { iterable }
     */

    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here

        return null;
    }

    /**
     * // return all possibilities(words),
     * find top k with highest frequency.

     *
     * @param      words  The words
     * @param      k      { size }
     *
     * @return     The suggestions.
     */
    public Iterable<String> getSuggestions(final
        Iterable<String> words, final int k) {
        // your code goes here
        HashMap<Integer, String> hashmap =
        new HashMap<Integer, String>();
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

        for (int j = 0; j < k; j++) {

            queue.enqueue(hashmap.get(array[j]));
        }

        return queue;
    }

    /**
     * // final output
    // Don't modify this method.
     *
     * @param      t9Signature  The t 9 signature
     * @param      k            { size}
     *
     * @return     { iterable }
     */
    public Iterable<String> t9(final String t9Signature, final int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
